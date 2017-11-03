package com.archospark.moviereviewservice.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="movie-reviews")
public class Review {
    @Id
    private Long id;
    private Long movie;
    private String review;

    public Review() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMovie() {
        return movie;
    }

    public void setMovie(Long movie) {
        this.movie = movie;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

}