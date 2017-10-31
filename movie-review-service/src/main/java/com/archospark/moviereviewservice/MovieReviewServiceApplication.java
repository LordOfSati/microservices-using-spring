package com.archospark.moviereviewservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableDiscoveryClient
@EnableMongoRepositories(basePackages="com.archospark.moviereviewservice.repositories")
@SpringBootApplication
public class MovieReviewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieReviewServiceApplication.class, args);
	}
}
