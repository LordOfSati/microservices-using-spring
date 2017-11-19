# Microservices using Spring Boot
#### Configuration files for these micro services are available in [Microservices using Spring Boot - Config](https://github.com/LordOfSati/microservices-using-spring-config) repo.

This is a simple microservices implementation using [Spring Cloud](https://cloud.spring.io/spring-cloud-netflix/single/spring-cloud-netflix.html) based on [@JoshLong's](https://github.com/joshlong) Cloud Native Java workshop.

The applications are boostraped using [Spring Initializer](http://start.spring.io)

## Modules Used

* [Config Server](https://cloud.spring.io/spring-cloud-config/) - Configurations are centralized using Spring Cloud Config Server
* Service Registry and Discovery - [Eureka](https://spring.io/guides/gs/service-registration-and-discovery/)
* Circuit Breaker Pattern - [Hystrix](https://spring.io/guides/gs/circuit-breaker/)
* Distributed Tracing - [Sleuth and Zipkin](https://spring.io/blog/2016/02/15/distributed-tracing-with-spring-cloud-sleuth-and-spring-cloud-zipkin)
* API Gateway - [Zuul](https://spring.io/guides/gs/routing-and-filtering/)
* [Feign](https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-feign.html) (a declarative REST client)
* Hystrix Dashboard

## Services

* Movie Service - Service to fetch movies list and details from the database.
* Movie Review Service - Service to fetch movie reviews from the database.
* Movie Cient Service - Edge Service (Consumes REST endpoints exposed by above mentioned services)

## Environment

* Java8
* MongoDb

## To be done

* Containerization
* Securing micro services
