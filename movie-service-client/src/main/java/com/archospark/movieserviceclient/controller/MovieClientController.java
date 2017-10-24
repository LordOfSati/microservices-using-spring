package com.archospark.movieserviceclient.controller;

import com.archospark.movieserviceclient.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class MovieClientController {

    private RestTemplate restTemplate;

    @Autowired
    public MovieClientController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/movies")
    public List<Movie> getMovies() {
        final String serviceUrl = "http://movie-service/movies";
        ParameterizedTypeReference<List<Movie>> parameterizedType = new
                ParameterizedTypeReference<List<Movie>>() {};
        ResponseEntity<List<Movie>> response = restTemplate.exchange(serviceUrl, HttpMethod.GET, null,
                parameterizedType);
        return response.getBody();
    }
}
