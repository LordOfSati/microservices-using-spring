package com.archospark.moviereviewservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.archospark.moviereviewservice.entities.Review;
import com.archospark.moviereviewservice.repositories.MovieReviewRepository;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class MovieReviewController {

    private MovieReviewRepository movieReviewRepository;

    @Autowired
    public MovieReviewController(MovieReviewRepository movieReviewRepository) {
        this.movieReviewRepository = movieReviewRepository;
    }

    @GetMapping(value = "/reviews/{movieId}")
    public List<Review> getReviewsForMovie(@PathVariable final Long movieId) {
        return movieReviewRepository.findByMovie(movieId);
    }
}