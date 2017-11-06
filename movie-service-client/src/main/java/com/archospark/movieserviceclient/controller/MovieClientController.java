package com.archospark.movieserviceclient.controller;

import com.archospark.movieserviceclient.client.MovieClient;
import com.archospark.movieserviceclient.client.MovieReviewClient;
import com.archospark.movieserviceclient.model.Movie;
import com.archospark.movieserviceclient.model.Review;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class MovieClientController {

    private MovieClient movieClient;

    private MovieReviewClient movieReviewClient;

    @Autowired
    public MovieClientController(MovieClient movieClient, MovieReviewClient movieReviewClient) {
        this.movieClient = movieClient;
        this.movieReviewClient = movieReviewClient;
    }

    @GetMapping(value="/movies")
    @HystrixCommand(fallbackMethod = "getMoviesFallback")
    public List<Movie> getMovies() {
        return movieClient.getMovies();
    }

    @GetMapping(value = "/movie/{movieId}")
    public Movie getMovieById(@PathVariable final Long movieId) {
        Movie movie = movieClient.getMovieById(movieId);
        if (null != movie) {
            List<Review> reviews = movieReviewClient.getMovieReviews(movieId);
            movie.setReviews(reviews);
        }
        return movie;
    }

    @GetMapping(value = "/movie/genre/{genre}")
    public List<Movie> getMoviesByGenre(@PathVariable final String genre) {
        return movieClient.getMoviesByGenre(genre);
    }

    @GetMapping(value = "/movie/year/{year}")
    public List<Movie> getMoviesByGenre(@PathVariable final Integer year) {
        return movieClient.getMoviesByYear(year);
    }

    @GetMapping(value = "/movies/names")
    public List<String> getMovieNames() {
        return movieClient.getMovieNames();
    }

    /* fallback methods */

    public List<Movie> getMoviesFallback() {
        return Collections.emptyList();
    }
}
