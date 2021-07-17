package com.tuncer.moviecreator.service;

import java.util.List;

import com.tuncer.moviecreator.model.Actor;

public interface ActorService {
	
	Actor getActorById(Long id);
	List<Actor> getActorByName(String name);
	Actor saveActor(Actor actor);
	Actor updateActor(Actor actor);
	void deleteActor(Long id);
	List<Actor> getActors();

}
