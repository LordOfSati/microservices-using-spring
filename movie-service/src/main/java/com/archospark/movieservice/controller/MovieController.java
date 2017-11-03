package com.archospark.movieservice.controller;

import com.archospark.movieservice.entities.Movie;
import com.archospark.movieservice.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/")
public class MovieController {
    private MovieRepository movieRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping(value = "/movie/{id}")
    public Movie getMovie(@PathVariable final Long id) {
        return movieRepository.findOne(id);
    }

    @GetMapping(value = "/movies")
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @GetMapping(value="/movies/names")
    public List<String> getMovieNames() {
        return movieRepository.findAll().stream().map(movie -> movie.getName()).collect(Collectors.toList());
    } 

    @GetMapping(value="/movies/genre/{genre}")
    public List<Movie> getMoviesByGenre(@PathVariable final String genre) {
        return movieRepository.findMoviesByGenre(genre);
    }

    @GetMapping(value="/movies/year/{year}")
    public List<Movie> getMoviesByYear(@PathVariable final Integer year) {
        return movieRepository.findMoviesByYear(year);
    }
}
