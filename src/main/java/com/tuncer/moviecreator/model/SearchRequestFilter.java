package com.tuncer.moviecreator.model;

import com.tuncer.moviecreator.types.GenreType;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class SearchRequestFilter implements Serializable {

    private String movieName;
    private String actorName;
    private GenreType genreType;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public GenreType getGenreType() {
        return genreType;
    }

    public void setGenreType(GenreType genreType) {
        this.genreType = genreType;
    }
}
