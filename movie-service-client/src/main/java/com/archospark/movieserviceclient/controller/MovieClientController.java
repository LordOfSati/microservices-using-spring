package com.archospark.movieserviceclient.controller;

import com.archospark.movieserviceclient.client.MovieClient;
import com.archospark.movieserviceclient.model.Movie;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class MovieClientController {

    private RestTemplate restTemplate;
    private MovieClient movieClient;

    @Autowired
    public MovieClientController(RestTemplate restTemplate, MovieClient movieClient) {
        this.restTemplate = restTemplate;
        this.movieClient = movieClient;
    }

    @GetMapping(value="/movies")
    @HystrixCommand(fallbackMethod = "getMoviesFallback")
    public List<Movie> getMovies() {
        return movieClient.getMovies();
    }

    public List<Movie> getMoviesFallback() {
        return Collections.emptyList();
    }
}
