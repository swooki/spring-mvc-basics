package com.kwonees.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	public HelloController() {
		System.out.println("HelloController instantiated");
	}

	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println("HelloController.sayHello() called");
		return "hello";
	}
}
