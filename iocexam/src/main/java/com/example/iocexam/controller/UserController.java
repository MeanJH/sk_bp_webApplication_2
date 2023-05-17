package com.example.iocexam.controller;

import com.example.iocexam.domain.User;
import com.example.iocexam.service.UserService;

public class UserController {
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	public void joinUser() {
		User user = new User();
		user.setName("kang");
		user.setEmail("carami@gmail.com");
		user.setPassword("1234");
		
		
		userService.joinUser(user);
	}
}
