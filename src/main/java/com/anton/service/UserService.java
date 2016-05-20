package com.anton.service;

import java.util.List;

import com.anton.model.User;

public interface UserService {
	public void add(User user);
	public void edit(User user);
	public void delete(Integer userId);
	public User getUser(Integer userId);
	public List getAllUser();
	public List<User> searchUsers(User user);
}
