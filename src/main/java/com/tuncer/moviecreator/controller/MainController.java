package com.tuncer.moviecreator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tuncer.moviecreator.model.User;
import com.tuncer.moviecreator.service.impl.UserServiceImpl;
import com.tuncer.moviecreator.util.Constants;

@Controller
public class MainController {

	@Autowired
	UserServiceImpl userService;
	
	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("user", new User());
		return Constants.Page.SIGNUP;
	}
	
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute(value="user") User user) {
		return userService.registerUser(user);
	}
	
}
