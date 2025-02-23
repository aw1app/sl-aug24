package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.sl")
@ComponentScan(basePackages = "com.sl")
@SpringBootApplication
public class SpringBootMongodbCoursesMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongodbCoursesMicroServiceApplication.class, args);
	}

}
