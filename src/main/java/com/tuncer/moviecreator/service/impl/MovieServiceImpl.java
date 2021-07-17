package com.tuncer.moviecreator.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuncer.moviecreator.model.Movie;
import com.tuncer.moviecreator.repository.MovieRepository;
import com.tuncer.moviecreator.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	MovieRepository movieRepository;

	@Override
	public Movie getMovieById(Long id) {
		return movieRepository.findById(id).get();
	}

	@Override
	public Movie updateMovie(Movie movie) {
		return movieRepository.save(movie);
	}

	@Override
	public List<Movie> getMovies() {
		return movieRepository.findAll();
	}

	@Override
	public void deleteMovie(Long id) {
		movieRepository.deleteById(id);
	}

	@Override
	public Movie saveMovie(Movie movie) {
		return movieRepository.save(movie);
	}


}
