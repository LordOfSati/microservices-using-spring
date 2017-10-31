package com.archospark.movieservice.repositories;

import com.archospark.movieservice.entities.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, Long> {
}
