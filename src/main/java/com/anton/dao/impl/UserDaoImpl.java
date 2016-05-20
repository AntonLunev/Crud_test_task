package com.anton.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anton.dao.UserDao;
import com.anton.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory session;
	
	
	public void add(User user) {
		session.getCurrentSession().save(user);
	}

	
	public void edit(User user) {
		
		User userToUpdate = getUser(user.getUserId());
		userToUpdate.setName(user.getName());
		userToUpdate.setAge(user.getAge());
		userToUpdate.setIsAdmin(user.getIsAdmin());
		session.getCurrentSession().update(userToUpdate);
		
	}

	
	public void delete(Integer userId) {		
		session.getCurrentSession().delete(getUser(userId));
	}

	
	public User getUser(Integer userId) {
		return (User)session.getCurrentSession().get(User.class, userId);
	}

	
	public List getAllUser() {
		return session.getCurrentSession().createQuery("from User").list();
	}
	
	public List<User> searchUsers(User user) {
		List<User> list = getAllUser();
		List<User> resultList = new ArrayList<>();


		if (user.getUserId()!=null) {
			for (User us : list) {
				if (us.getUserId().equals(user.getUserId())) {
					resultList.add(us);
				}
			}
			if (user.getName() != null) {
				Iterator<User> it = resultList.iterator();
				while (it.hasNext()) {
					User taken = it.next();
					if (!taken.getName().contains(user.getName())) {
						it.remove();
					}
				}
			}
			if (user.getAge() != null) {
				Iterator<User> it = resultList.iterator();
				while (it.hasNext()) {
					User taken = it.next();
					if (!taken.getAge().equals(user.getAge())) {
						it.remove();
					}
				}

			}
			if (user.getIsAdmin()!=null){
				Iterator<User> it = resultList.iterator();
				while (it.hasNext()) {
					User taken = it.next();
					if (!taken.getIsAdmin().equals(user.getIsAdmin())) {
						it.remove();
					}
				}
			}
		}
		else if (user.getName()!=null){
			for(User us : list) {
				if (us.getName().contains(user.getName())) {
					resultList.add(us);
				}
			}
			if (user.getAge() != null) {
				Iterator<User> it = resultList.iterator();
				while (it.hasNext()) {
					User taken = it.next();
					if (!taken.getAge().equals(user.getAge())) {
						it.remove();
					}
				}

			}
			if (user.getIsAdmin()!=null){
				Iterator<User> it = resultList.iterator();
				while (it.hasNext()) {
					User taken = it.next();
					if (!taken.getIsAdmin().equals(user.getIsAdmin())) {
						it.remove();
					}
				}
			}
		}
		else if (user.getAge()!=null){
			for(User us : list) {
				if (us.getAge().equals(user.getAge())) {
					resultList.add(us);
				}
			}
			if (user.getIsAdmin()!=null){
				Iterator<User> it = resultList.iterator();
				while (it.hasNext()) {
					User taken = it.next();
					if (!taken.getIsAdmin().equals(user.getIsAdmin())) {
						it.remove();
					}
				}
			}

		}
		else if (user.getIsAdmin()!=null){
			for(User us : list) {
				if (us.getIsAdmin().equals(user.getIsAdmin())) {
					resultList.add(us);
				}
			}


		}
		if(user.getUserId()==null && user.getName()==null && user.getAge()==null && user.getIsAdmin()==null) {
			resultList.clear();
		}
		return resultList;
	}

}
