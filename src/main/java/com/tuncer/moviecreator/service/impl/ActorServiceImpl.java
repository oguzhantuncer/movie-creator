package com.tuncer.moviecreator.service.impl;

import com.tuncer.moviecreator.model.Actor;
import com.tuncer.moviecreator.model.SearchRequestFilter;
import com.tuncer.moviecreator.repository.ActorRepository;
import com.tuncer.moviecreator.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

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

    @Override
    public Actor updateActor(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public void deleteActor(Long id) {
        actorRepository.deleteById(id);
    }

    @Override
    public void fillModel(Model model) {
        model.addAttribute("actors",getActors());
        model.addAttribute("actor", new Actor());
        model.addAttribute("search", new SearchRequestFilter());
    }

    @Override
    public List<Actor> getActorByName(String name) {
        return actorRepository.findByName(name);
    }

    @Override
    public List<Actor> search(SearchRequestFilter searchRequestFilter) {
        return actorRepository.findByName(searchRequestFilter.getActorName());
    }

}
