package com.anton.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anton.dao.UserDao;
import com.anton.model.User;
import com.anton.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Transactional
	public void add(User user) {
		userDao.add(user);
	}

	@Transactional
	public void edit(User user) {
		userDao.edit(user);
	}

	@Transactional
	public void delete(Integer userId) {
		userDao.delete(userId);
	}

	@Transactional
	public User getUser(Integer userId) {
		return userDao.getUser(userId);
	}

	@Transactional
	public List getAllUser() {
		return userDao.getAllUser();
	}
	
	@Transactional
	public List<User> searchUsers(User user) {
		return userDao.searchUsers(user);
	}

}
