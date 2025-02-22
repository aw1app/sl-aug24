package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;


@ComponentScan(basePackages = {"com.sl"})
@SpringBootApplication
public class SpringBootMongodbCoursesUiMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongodbCoursesUiMicroServiceApplication.class, args);
	}
	
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
