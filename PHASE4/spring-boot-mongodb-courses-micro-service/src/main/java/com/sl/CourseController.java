package com.sl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
    private CourseRepository courseRepository;
	
	@GetMapping("/all")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
	
	
	@GetMapping("/course/{id}")
    public Course getCourseById(@PathVariable String id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        return courseOptional.orElse(null);
    }
	
	@PostMapping("/add-course")
    public Course addCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

}
