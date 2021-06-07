package com.kwonees.web.services;

public class GreetingService {
	public String getMessage(String name) {
		if(name == null) {
			name = "MVC";	
		}
		return ("Hello! " + name);
	}
}
