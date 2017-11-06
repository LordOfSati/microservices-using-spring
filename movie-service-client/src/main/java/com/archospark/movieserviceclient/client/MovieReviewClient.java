package com.archospark.movieserviceclient.client;

import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.archospark.movieserviceclient.model.Review;

@FeignClient(name = "movie-review-service")
public interface MovieReviewClient {
    @GetMapping(value = "/reviews/{movieId}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Review> getMovieReviews(@PathVariable("movieId") final Long movieId);
}