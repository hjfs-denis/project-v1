package com.egalaxy.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egalaxy.user.entity.User;
import com.egalaxy.user.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/user")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/all")
	public List<User> getUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping(value = "/add",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@PutMapping(value = "/update/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateUser(@PathVariable(value = "id") int userId, @RequestBody User user) {
		userService.updateUser(user);
	}
	
	@DeleteMapping(value= "/deleteAll")
	public void deleteBooks() {
		userService.deleteAllUsers();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteBook(@PathVariable(value = "id") int userId) {
		userService.deleteUser(userId);
	}

	
	@GetMapping(value = "/get/{id}")
	public Optional<User> getOneCustomer(@PathVariable(value = "id") int userId) {
		return userService.getUser(userId);
	}
	



}
