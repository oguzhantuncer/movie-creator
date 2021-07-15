package com.tuncer.moviecreator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuncer.moviecreator.model.Movie;
import com.tuncer.moviecreator.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@GetMapping("/{id}")	
	public Movie getMovieById(@PathVariable Long id) {
		return movieService.getMovieById(id);
	}
	
	@GetMapping("/hp")	
	public String getHP() {
		return "Harry Potter";
	}
	
	@GetMapping()	
	public String getMovie() {
		return "A.R.O.G.";
	}
}
