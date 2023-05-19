package com.example.todo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@GetMapping("/")
	@ResponseBody
	public String hello() {
		return "hi spring mvc";
	}
	
	@GetMapping("/hi")
	public String hi(String msg, HttpServletRequest request) {
		return "hi";
	}

}
