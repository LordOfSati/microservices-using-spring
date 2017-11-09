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
    @HystrixCommand(fallbackMethod = "getMovieByIdFallback")
    public Movie getMovieById(@PathVariable final Long movieId) {
        Movie movie = movieClient.getMovieById(movieId);
        if (null != movie) {
            movie.setReviews(getMovieReviews(movieId));
        }
        return movie;
    }

    @HystrixCommand(fallbackMethod = "getMovieReviewsFallback")
    public List<Review> getMovieReviews(final Long movieId) {
        return movieReviewClient.getMovieReviews(movieId);
    }

    @GetMapping(value = "/movie/genre/{genre}")
    @HystrixCommand(fallbackMethod = "getMoviesByGenreFallback")
    public List<Movie> getMoviesByGenre(@PathVariable final String genre) {
        return movieClient.getMoviesByGenre(genre);
    }

    @GetMapping(value = "/movie/year/{year}")
    @HystrixCommand(fallbackMethod = "getMoviesByYearFallback")
    public List<Movie> getMoviesByYear(@PathVariable final Integer year) {
        return movieClient.getMoviesByYear(year);
    }

    @GetMapping(value = "/movies/names")
    @HystrixCommand(fallbackMethod = "getMovieNamesFallback")
    public List<String> getMovieNames() {
        return movieClient.getMovieNames();
    }

    /* Fallback methods */

    public List<Movie> getMoviesFallback() {
        return Collections.emptyList();
    }

    public Movie getMovieByIdFallback(final Long movieId) {
        return null;
    }

    public List<Review> getMovieReviewsFallback(final Long movieId) {
        return Collections.emptyList();
    }

    public List<Movie> getMoviesByGenreFallback(final String genre) {
        return Collections.emptyList();
    }

    public List<Movie> getMoviesByYearFallback(final Integer year) {
        return Collections.emptyList();
    }

    public List<String> getMovieNamesFallback() {
        return Collections.emptyList();
    }
}
