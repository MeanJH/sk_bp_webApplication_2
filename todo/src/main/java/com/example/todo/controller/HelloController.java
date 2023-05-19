package com.example.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String hi(String msg, Model model) {
		
		return "hi";
	}

}
