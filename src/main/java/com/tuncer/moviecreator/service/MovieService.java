package com.tuncer.moviecreator.service;

import java.util.List;

import com.tuncer.moviecreator.model.Movie;

public interface MovieService {
	
	Movie saveMovie(Movie movie);
	List<Movie> getMovies();
	Movie getMovieById(Long id);
	Movie updateMovie(Movie movie);
	void deleteMovie(Long id);
	

}
