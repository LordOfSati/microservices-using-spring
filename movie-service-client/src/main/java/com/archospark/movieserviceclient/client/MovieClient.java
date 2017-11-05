package com.archospark.movieserviceclient.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.archospark.movieserviceclient.model.Movie;

@FeignClient(name = "movie-service")
public interface MovieClient {
    @GetMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Movie> getMovies();

    @GetMapping(value = "/movie/{movieId}", produces = MediaType.APPLICATION_JSON_VALUE)
    Movie getMovieById(@PathVariable final Long movieId);

    @GetMapping(value = "/movies/names", produces = MediaType.APPLICATION_JSON_VALUE)
    List<String> getMovieNames();

    @GetMapping(value = "/movies/year/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Movie> getMoviesByYear(@PathVariable final Integer year);

    @GetMapping(value = "/movies/genre/{genre}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Movie> getMoviesByGenre(@PathVariable final String genre);
}