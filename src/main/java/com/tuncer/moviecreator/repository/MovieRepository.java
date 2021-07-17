package com.tuncer.moviecreator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tuncer.moviecreator.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	Movie findByName(String name);

}
