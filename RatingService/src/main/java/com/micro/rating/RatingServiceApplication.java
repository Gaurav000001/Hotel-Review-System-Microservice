package com.micro.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableEurekaClient is deprecated, no need to annotate the main class.
//It is enough to add the spring-cloud-starter-netflix-eureka-client dependency
//to pom.xml and if we have the application name in yml or properties file it
//will be registered to Eureka Server.

@SpringBootApplication
public class RatingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingServiceApplication.class, args);
	}

}
