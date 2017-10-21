package com.archospark.movieservice.config;

import com.archospark.movieservice.entities.Movie;
import com.archospark.movieservice.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Component
public class Loader {

    private MovieRepository movieRepository;

    @Autowired
    public Loader(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @PostConstruct
    public void populateMovies() {
        System.out.println("Hello");
        List<Movie> movies = Arrays.asList(
                new Movie("Jeans", "Directed by Shankar", 1998, 180),
                new Movie("Roja", "Directed by Mani Ratnam", 1992, 150),
                new Movie("Batman Begins", "Directed by Christopher Nolan", 2005, 170),
                new Movie("The Dark Knight", "Directed by Christopher Nolan", 2008, 182),
                new Movie("Boys", "Directed by Shankar", 2004, 188),
                new Movie("Bombay", "Directed by Mani Ratnam", 1994, 175),
                new Movie("Titanic", "Directed by James Cameron", 1997, 165),
                new Movie("The Bridge of Spies", "Directed by Steven Speilberg", 2015, 160)
                );
        movies.stream().forEach(movie -> this.movieRepository.save(movie));
    }
}
