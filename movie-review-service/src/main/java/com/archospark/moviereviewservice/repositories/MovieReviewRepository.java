package com.archospark.moviereviewservice.repositories;

import com.archospark.moviereviewservice.entities.Review;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieReviewRepository extends MongoRepository<Review, Long> {
    List<Review> findByMovie(Long movieId);
}