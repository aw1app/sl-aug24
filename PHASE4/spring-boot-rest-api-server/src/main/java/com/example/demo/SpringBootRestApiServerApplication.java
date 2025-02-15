package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.sl.repositry")
@EntityScan(basePackages = "com.sl.entity")
@ComponentScan({"com.sl.controller"})
public class SpringBootRestApiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiServerApplication.class, args);
	}

}
