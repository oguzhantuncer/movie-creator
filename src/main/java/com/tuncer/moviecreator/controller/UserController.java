package com.tuncer.moviecreator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tuncer.moviecreator.model.User;
import com.tuncer.moviecreator.service.impl.UserServiceImpl;

@Controller
public class UserController {

	@Autowired
	private UserServiceImpl userService;
	
	@PostMapping("/signup")
	public String registerUser(@ModelAttribute User user) {
		return userService.registerUser(user);
	}
	

}
