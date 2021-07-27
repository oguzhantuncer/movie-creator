package com.tuncer.moviecreator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tuncer.moviecreator.model.Movie;
import com.tuncer.moviecreator.service.MovieService;

//TODO Must be convert web controller
@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@GetMapping("/{id}")	
	public Movie getMovieById(@PathVariable Long id) {
		return movieService.getMovieById(id);
	}
	
	@GetMapping
	public List<Movie> getMovies(){
		return movieService.getMovies();
	}
	
	@PostMapping
	public Movie saveMovie(@RequestBody Movie movie) {
		return movieService.updateMovie(movie);
	}
	
	@PutMapping
	public Movie updateMovie(@RequestBody Movie movie) {
		return movieService.updateMovie(movie);
	}
	
	@DeleteMapping("/{id}")
	public void deleteMovie(@PathVariable Long id) {
		movieService.deleteMovie(id);
	}
	
}
