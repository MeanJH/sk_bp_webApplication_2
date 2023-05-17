package com.example.iocexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.iocexam.controller.UserController;

@SpringBootApplication
public class IocexamApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(IocexamApplication.class, args);
	}
//	@Autowired
//	ApplicationContext context;
	
	@Autowired
	UserController userController;
	
	@Override
	public void run(String... args) throws Exception {
		userController.joinUser();
	}

}
