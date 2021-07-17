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

import com.tuncer.moviecreator.model.Actor;
import com.tuncer.moviecreator.service.ActorService;

@RestController
@RequestMapping("/actor")
public class ActorController {

	@Autowired
	private ActorService actorService;
	
	@GetMapping
	public List<Actor> getActors() {
		return actorService.getActors();
	}
	
	@GetMapping("/{id}")	
	public Actor getActorById(@PathVariable Long id) {
		return actorService.getActorById(id);
	}
	
	@GetMapping("/name/{name}")	
	public List<Actor> getActorByName(@PathVariable String name) {
		return actorService.getActorByName(name);
	}
	
	@PostMapping
	public Actor saveActor(@RequestBody Actor actor) {
		return actorService.saveActor(actor);
	}
	
	@PutMapping
	public Actor updateActor(@RequestBody Actor actor) {
		return actorService.updateActor(actor); 
		
	}
	
	@DeleteMapping("/{id}") 
	public void deleteActor(@PathVariable Long id) {
		actorService.deleteActor(id);
	}

}
