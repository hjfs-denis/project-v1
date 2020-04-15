package com.egalaxy.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egalaxy.user.entity.User;
import com.egalaxy.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(int userId) {
		return userRepository.getOne(userId);
	}

	@Override
	public void deleteAllUsers() {
		userRepository.deleteAll();
	}

	@Override
	public void deleteUser(int userId) {
		userRepository.deleteById(userId);
	}

	@Override
	public void updateUser(User user) {
		userRepository.saveAndFlush(user);
	}

	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}

}
