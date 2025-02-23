package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableDiscoveryClient
@EnableMongoRepositories(basePackages = "com.sl")
@ComponentScan(basePackages = "com.sl")
@SpringBootApplication
public class SpringBootMongodbCoursesMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongodbCoursesMicroServiceApplication.class, args);
	}

}
