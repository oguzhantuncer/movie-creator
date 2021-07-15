package com.tuncer.moviecreator.service.impl;

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


}
