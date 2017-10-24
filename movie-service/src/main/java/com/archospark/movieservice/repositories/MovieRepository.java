package com.archospark.movieservice.repositories;

import com.archospark.movieservice.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
