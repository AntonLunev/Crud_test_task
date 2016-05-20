package com.anton.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.anton.model.User;
import com.anton.service.UserService;
import com.anton.controller.FormValidator;

@Controller
public class UserController {
	List<User> searResult = new ArrayList<>();

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addUserPage(User user) {

		return "add-user-form";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingUser(@ModelAttribute User user, BindingResult result) {

		FormValidator formValidator = new FormValidator();

		formValidator.validate(result.getModel().get("user"), result);
		if(result.hasErrors()){

			ModelAndView modelAndView = new ModelAndView("add-user-form",result.getModel());

			return modelAndView;
		}

		ModelAndView modelAndView = new ModelAndView("home");
		userService.add(user);
		
		String message = "User \"" + user.getName() + "\"  added successfully";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value={"/list","/","/index"})
	public ModelAndView listOfUsers(@RequestParam(required = false) Integer page) {
		ModelAndView modelAndView = new ModelAndView("list-of-users");
		
		List<User> users = userService.getAllUser();
		PagedListHolder<User> pagedListHolder = new PagedListHolder<>(users);
		pagedListHolder.setPageSize(10);
		modelAndView.addObject("maxPages", pagedListHolder.getPageCount());

		if(page==null || page < 1 || page > pagedListHolder.getPageCount())page=1;

		modelAndView.addObject("page", page);
		if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
			pagedListHolder.setPage(0);
			modelAndView.addObject("users", pagedListHolder.getPageList());
		}
		else if(page <= pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(page-1);
			modelAndView.addObject("users", pagedListHolder.getPageList());
		}

		return modelAndView;
	}
	@RequestMapping(value="result")
	public ModelAndView resultOfSearch(@RequestParam(required = false) Integer page) {
		ModelAndView modelAndView;
		if(!searResult.isEmpty()){
			modelAndView = new ModelAndView("result-of-search");
			PagedListHolder<User> pagedListHolder = new PagedListHolder<>(searResult);
			pagedListHolder.setPageSize(10);
			modelAndView.addObject("maxPages", pagedListHolder.getPageCount());
			modelAndView.addObject("sizeresult", pagedListHolder.getNrOfElements());

			if(page==null || page < 1 || page > pagedListHolder.getPageCount())page=1;

			modelAndView.addObject("page", page);
			if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
				pagedListHolder.setPage(0);
				modelAndView.addObject("users", pagedListHolder.getPageList());
			}
			else if(page <= pagedListHolder.getPageCount()) {
				pagedListHolder.setPage(page-1);
				modelAndView.addObject("users", pagedListHolder.getPageList());
			}
		}
		else {

			modelAndView = new ModelAndView("search-users");
			modelAndView.addObject("searchUser", new User());
			modelAndView.addObject("isSearch", "Users not fount, fill the form");
		}


		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{userId}", method=RequestMethod.GET)
	public ModelAndView editUserPage(@PathVariable Integer userId) {
		ModelAndView modelAndView = new ModelAndView("edit-user-form");
		User user = userService.getUser(userId);
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{userId}", method=RequestMethod.POST)
	public ModelAndView edditingUser(@ModelAttribute User user, @PathVariable Integer userId) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		user.setUserId(userId);
		userService.edit(user);
		
		String message = "User \"" + user.getName() + "\"  updated successfully.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteUser(@PathVariable Integer id) {
		if(!searResult.isEmpty()){
			for(User us : searResult)
			{
				if(us.getUserId()==(id)){
					searResult.remove(us);
					break;
				}
			}
		}
		ModelAndView modelAndView = new ModelAndView("home");
		String deletedName = userService.getUser(id).getName();
		userService.delete(id);
		String message = "User \"" + deletedName + "\"  deleted successfully.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}

	@RequestMapping(value="/search-init", method=RequestMethod.GET)
	public ModelAndView searchUser() {
		ModelAndView modelAndView = new ModelAndView("search-users");

		modelAndView.addObject("searchUser", new User());
		return modelAndView;
	}
	@RequestMapping(value="/search-init", method = RequestMethod.POST)
	public ModelAndView searchUser(@ModelAttribute User user, @RequestParam(required = false) Integer page) {
		ModelAndView modelAndView = new ModelAndView("result-of-search");
		
		
		searResult = userService.searchUsers(user);

		PagedListHolder<User> pagedListHolder = new PagedListHolder<>(searResult);
		pagedListHolder.setPageSize(10);
		modelAndView.addObject("maxPages", pagedListHolder.getPageCount());
		modelAndView.addObject("sizeresult", pagedListHolder.getNrOfElements());

		if(page==null || page < 1 || page > pagedListHolder.getPageCount())page=1;

		modelAndView.addObject("page", page);
		if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
			pagedListHolder.setPage(0);
			modelAndView.addObject("users", pagedListHolder.getPageList());
		}
		else if(page <= pagedListHolder.getPageCount()) {
			pagedListHolder.setPage(page-1);
			modelAndView.addObject("users", pagedListHolder.getPageList());
		}

		return modelAndView;
	}

}
