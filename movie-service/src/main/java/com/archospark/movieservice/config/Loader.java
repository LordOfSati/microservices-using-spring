package com.archospark.movieservice.config;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Loader {

    @PostConstruct
    public void populateMovies() {
        System.out.println("data loading can be done here..");
    }
}
