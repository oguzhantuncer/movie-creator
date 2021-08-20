package com.tuncer.moviecreator.model;

import com.tuncer.moviecreator.types.GenreType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer publishYear;
    @Enumerated
    @Column(name = "GENRELIST")
    private GenreType genreList;
    private String description;
    private String production;

    @ManyToMany
    @JoinTable(name="movie_actors", joinColumns = @JoinColumn(name = "movie_id"),inverseJoinColumns = @JoinColumn(name="actor_id"))
    private List<Actor> actorsInMovie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public GenreType getGenreList() {
        return genreList;
    }

    public void setGenreList(GenreType genreList) {
        this.genreList = genreList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public List<Actor> getActorsInMovie() {
        return actorsInMovie;
    }

    public void setActorsInMovie(List<Actor> actorsInMovie) {
        this.actorsInMovie = actorsInMovie;
    }
}