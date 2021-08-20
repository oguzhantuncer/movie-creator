package com.tuncer.moviecreator.controller;

import com.tuncer.moviecreator.model.Movie;
import com.tuncer.moviecreator.model.User;
import com.tuncer.moviecreator.service.impl.UserServiceImpl;
import com.tuncer.moviecreator.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/signup")
    public String registerUser(@ModelAttribute User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/users")
    public String users(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return Constants.Page.USERS;
    }

    @PostMapping("/user/delete")
    public String saveMovie(@ModelAttribute(value = "user") User user, Model model) {
        userService.deleteUser(user);
        userService.fillModel(model);
        return Constants.Page.USERS;
    }




}
