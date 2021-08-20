package com.tuncer.moviecreator.controller;

import com.tuncer.moviecreator.model.SearchRequestFilter;
import com.tuncer.moviecreator.model.User;
import com.tuncer.moviecreator.service.MovieService;
import com.tuncer.moviecreator.service.impl.UserServiceImpl;
import com.tuncer.moviecreator.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    MovieService movieService;


    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return Constants.Page.SIGNUP;
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute(value = "user") User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/search")
    public String registerUser(@ModelAttribute(value = "search") SearchRequestFilter searchRequestFilter, Model model) {
        model.addAttribute("movies",movieService.search(searchRequestFilter));
        return Constants.Page.MOVIES;
    }


}
