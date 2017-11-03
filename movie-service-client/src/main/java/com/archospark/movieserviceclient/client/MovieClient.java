package com.archospark.movieserviceclient.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import com.archospark.movieserviceclient.model.Movie;

@FeignClient(name = "movie-service")
public interface MovieClient {
    @GetMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Movie> getMovies();
}