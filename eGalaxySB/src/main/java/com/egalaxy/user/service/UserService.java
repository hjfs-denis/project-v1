package com.egalaxy.user.service;

import java.util.List;

import com.egalaxy.user.entity.User;

public interface UserService {
	
	List<User> getAllUsers();
	User getUser(int userId);
	public void deleteAllUsers();
	public void deleteUser(int userId);
	public void updateUser(User user);
	public void addUser(User user);

}
