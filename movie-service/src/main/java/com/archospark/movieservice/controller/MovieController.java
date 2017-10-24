package com.archospark.movieservice.controller;

import com.archospark.movieservice.entities.Movie;
import com.archospark.movieservice.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class MovieController {
    private MovieRepository movieRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping(value = "/movies/{id}")
    public Movie getMovie(@PathVariable final Long id) {
        return movieRepository.findOne(id);
    }

    @GetMapping(value = "/movies")
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }
}
