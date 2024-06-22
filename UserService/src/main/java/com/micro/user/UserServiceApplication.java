package com.micro.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableEurekaClient is deprecated, no need to annotate the main class. 
//It is enough to add the spring-cloud-starter-netflix-eureka-client dependency 
//to pom.xml and if we have the application name in yml or properties file it 
//will be registered to Eureka Server.

@SpringBootApplication
@EnableFeignClients
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
