package com.tuncer.moviecreator.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuncer.moviecreator.model.Actor;
import com.tuncer.moviecreator.model.Movie;
import com.tuncer.moviecreator.repository.ActorRepository;
import com.tuncer.moviecreator.repository.MovieRepository;
import com.tuncer.moviecreator.service.ActorService;
import com.tuncer.moviecreator.service.MovieService;

@Service
public class ActorServiceImpl implements ActorService {
	
	@Autowired
	ActorRepository actorRepository;

	@Override
	public Actor getActorById(Long id) {
		return actorRepository.findById(id).get();
		
	}

	@Override
	public Actor saveActor(Actor actor) {
		return actorRepository.save(actor);
	}

	@Override
	public List<Actor> getActors() {
		return actorRepository.findAll();
	}

}
