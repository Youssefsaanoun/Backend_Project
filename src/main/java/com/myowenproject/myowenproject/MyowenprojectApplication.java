package com.myowenproject.myowenproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@ComponentScan(basePackages = {"com.controllers", "com.serviseimplementation", "com.repository"})
@EntityScan(basePackages = "com.models")
@EnableJpaRepositories(basePackages = "com.repository")
public class MyowenprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyowenprojectApplication.class, args);
	}

}
