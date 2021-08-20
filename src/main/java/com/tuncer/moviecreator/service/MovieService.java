package com.tuncer.moviecreator.service;

import com.tuncer.moviecreator.model.Movie;
import com.tuncer.moviecreator.model.SearchRequestFilter;
import org.springframework.ui.Model;

import java.util.List;

public interface MovieService {

    Movie saveMovie(Movie movie);

    List<Movie> getMovies();

    List<Movie> search(SearchRequestFilter searchRequestFilter);

    Movie getMovieById(Long id);

    Movie updateMovie(Movie movie);

    void deleteMovie(Long id);

    void fillModel(Model model);

}
