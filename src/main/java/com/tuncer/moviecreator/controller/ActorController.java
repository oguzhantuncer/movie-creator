package com.tuncer.moviecreator.controller;

import com.tuncer.moviecreator.model.Actor;
import com.tuncer.moviecreator.model.Movie;
import com.tuncer.moviecreator.model.SearchRequestFilter;
import com.tuncer.moviecreator.service.ActorService;
import com.tuncer.moviecreator.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping
    public String getActors(Model model) {

        Object principal = SecurityContextHolder. getContext(). getAuthentication(). getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            model.addAttribute("username", username);
        }
        actorService.fillModel(model);
        return Constants.Page.ACTORS;
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
    public String saveMovie(@ModelAttribute(value = "actor") Actor actor, Model model) {
        actorService.saveActor(actor);
        actorService.fillModel(model);
        return Constants.Page.ACTORS;
    }

    @PostMapping("/delete")
    public String deleteActor(@ModelAttribute(value = "actor") Actor actor, Model model) {
        actorService.deleteActor(actor.getId());
        actorService.fillModel(model);
        return Constants.Page.ACTORS;
    }

    @PutMapping
    public Actor updateActor(@RequestBody Actor actor) {
        return actorService.updateActor(actor);
    }

    @PostMapping("/create")
    public String toCreatePage(Model model) {
        model.addAttribute("actor", new Actor());
        return Constants.Page.ACTORS_CREATE;
    }

    @PostMapping("/search")
    public String registerUser(@ModelAttribute(value = "search") SearchRequestFilter searchRequestFilter, Model model) {
        model.addAttribute("actors",actorService.search(searchRequestFilter));
        return Constants.Page.ACTORS;
    }

    @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable Long id) {
        actorService.deleteActor(id);
    }

}
