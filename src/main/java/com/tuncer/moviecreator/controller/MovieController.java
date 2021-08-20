package com.tuncer.moviecreator.controller;

import com.tuncer.moviecreator.model.Actor;
import com.tuncer.moviecreator.model.Movie;
import com.tuncer.moviecreator.model.SearchRequestFilter;
import com.tuncer.moviecreator.model.User;
import com.tuncer.moviecreator.service.ActorService;
import com.tuncer.moviecreator.service.MovieService;
import com.tuncer.moviecreator.service.impl.UserServiceImpl;
import com.tuncer.moviecreator.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private ActorService actorService;

    @GetMapping
    public String movie(Model model) {
        movieService.fillModel(model);
        return Constants.Page.MOVIES;
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getMovieById(id);
    }

    @PostMapping("/actor")
    public String addActor(@ModelAttribute(value = "movie") Movie movie, Model model) {
        model.addAttribute("movie", movie);
        actorService.fillModel(model);
        return Constants.Page.MOVIES_ADD_ACTOR;
    }

    @PostMapping
    public String saveMovie(@ModelAttribute(value = "movie") Movie movie, Model model) {
        movieService.saveMovie(movie);
        movieService.fillModel(model);
        return Constants.Page.MOVIES;
    }

    @PostMapping("/delete")
    public String deleteMovie(@ModelAttribute(value = "movie") Movie movie, Model model) {
        movieService.deleteMovie(movie.getId());
        movieService.fillModel(model);
        return Constants.Page.MOVIES;
    }

    @PutMapping
    public Movie updateMovie(@ModelAttribute(value = "movie") Movie movie) {
        return movieService.updateMovie(movie);
    }

    @PostMapping("/edit")
    public String toEditPage(@ModelAttribute(value = "movie") Movie movie, Model model) {
        model.addAttribute("movie", movie);
        return Constants.Page.MOVIES_EDIT;
    }

    @PostMapping("/search")
    public String registerUser(@ModelAttribute(value = "search") SearchRequestFilter searchRequestFilter, Model model) {
        model.addAttribute("movies",movieService.search(searchRequestFilter));
        return Constants.Page.MOVIES;
    }

    @PostMapping("/create")
    public String toCreatePage(Model model) {
        model.addAttribute("movie", new Movie());
        return Constants.Page.MOVIES_CREATE;
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }

}
