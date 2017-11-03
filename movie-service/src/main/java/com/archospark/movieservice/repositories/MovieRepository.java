package com.archospark.movieservice.repositories;

import com.archospark.movieservice.entities.Movie;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MovieRepository extends MongoRepository<Movie, Long> {
    @Query(value = "{ 'genre' : {$eq : ?0 }}")
    List<Movie> findMoviesByGenre(String genre);
    @Query(value = "{ 'releaseYear' : {$eq : ?0 }}")
    List<Movie> findMoviesByYear(Integer year);
}
