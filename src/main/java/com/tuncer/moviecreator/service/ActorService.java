package com.tuncer.moviecreator.service;

import java.util.List;

import com.tuncer.moviecreator.model.Actor;

public interface ActorService {
	
	Actor getActorById(Long id);
	Actor saveActor(Actor actor);	
	List<Actor> getActors();

}
