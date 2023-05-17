package com.example.iocexam.config;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.example.iocexam")
public class UserConfig {
//	@Bean
//	public UserDao userDao() {
//		return new UserDaoImpl();
//	}
//
//	@Bean
//	public UserDao userCaramiDao() {
//		return new UserCaramiDaoImpl();
//	}
//	
//	@Bean
//	public UserService userService(UserDao userCaramiDao) {
//		return new UserServiceImpl(userCaramiDao);
//	}
//	
//	@Bean
//	public UserController userController(UserService userService) {
//		return new UserController(userService);
//	}
}
