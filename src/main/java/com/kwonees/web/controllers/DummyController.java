package com.kwonees.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DummyController {
	public DummyController() {
		System.out.println("DummyController instantiated");
	}

	@RequestMapping("/dummy")
	public String sayHello() {
		System.out.println("DummyController.sayHello() called");
		return "/WEB-INF/pages/dummy.jsp";
	}

}
