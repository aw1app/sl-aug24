package com.sl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Controller
public class UIController{
	
	
	// Connect to the courses micro service
	// using RestTemplate
	
	@Autowired
    private RestTemplate restTemplate;
	
	@GetMapping("/display-courses")
	public String displayAllCourses(Model model) {
		
		try {
		
		List<Course> courses = restTemplate.exchange(
				//"http://localhost:8081/courses/all", 
				"http://spring-cloud-mongodb-courses-micro-service/courses/all",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference< List<Course> >()  {}
				).
				getBody();
		
		model.addAttribute("courses", courses);
		model.addAttribute("hasError", false);
		}catch(Exception e) {
			System.out.println("ERROR "+e.getMessage());
			model.addAttribute("hasError", true);
		};
		
		return "courses"; // courses.jsp
		
	}
	
	
	@GetMapping("/display-course/{id}")
	public String displayAllCourses(@PathVariable String id, Model model) {
		
		Course course = restTemplate.exchange(
				"http://spring-cloud-mongodb-courses-micro-service/courses/course/"+id, 
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference< Course >()  {}
				).
				getBody();
		
		model.addAttribute("course", course);
		
		return "course"; // course.jsp
		
	}
	
	
}