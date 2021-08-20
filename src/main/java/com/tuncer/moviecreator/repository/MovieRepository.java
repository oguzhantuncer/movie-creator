package com.tuncer.moviecreator.repository;

import com.tuncer.moviecreator.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findByName(String name);

    @Query(name = "searchAllMoviesByRequestFilter",
            value = "SELECT m.* " +
                    "FROM movie m " +
                    "WHERE m.name like %:movieName% " +
                    "OR m.genreList= :genreList",
            nativeQuery = true)
    List<Movie> searchMoviesByRequestFilter(
            @Param("movieName") String movieName,
            @Param("genreList") Integer genreList);
}
