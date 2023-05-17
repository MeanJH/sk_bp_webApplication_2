package com.example.iocexam.controller;

import org.springframework.stereotype.Controller;

import com.example.iocexam.domain.User;
import com.example.iocexam.service.UserService;

import jakarta.annotation.Resource;
@Controller
public class UserController {
	@Resource
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
