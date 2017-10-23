package com.archospark.movieserviceclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MovieServiceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieServiceClientApplication.class, args);
	}
}
