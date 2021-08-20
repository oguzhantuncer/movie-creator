package com.tuncer.moviecreator.service;

import com.tuncer.moviecreator.model.Actor;
import com.tuncer.moviecreator.model.SearchRequestFilter;
import org.springframework.ui.Model;

import java.util.List;

public interface ActorService {

    Actor getActorById(Long id);

    List<Actor> getActorByName(String name);

    List<Actor> search(SearchRequestFilter searchRequestFilter);

    Actor saveActor(Actor actor);

    Actor updateActor(Actor actor);

    List<Actor> getActors();

    void deleteActor(Long id);

    void fillModel(Model model);

}
