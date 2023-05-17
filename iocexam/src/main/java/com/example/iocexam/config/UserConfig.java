package com.example.iocexam.config;

import org.springframework.context.annotation.Bean;

import com.example.iocexam.controller.UserController;
import com.example.iocexam.dao.UserDao;
import com.example.iocexam.dao.UserDaoImpl;
import com.example.iocexam.service.UserService;
import com.example.iocexam.service.UserServiceImpl;

public class UserConfig {
	@Bean
	public UserDao userDao() {
		return new UserDaoImpl();
	}
	
	@Bean
	public UserService userService(UserDao userDao) {
		return new UserServiceImpl(userDao);
	}
	
	@Bean
	public UserController userController(UserService userService) {
		return new UserController(userService);
	}
}
