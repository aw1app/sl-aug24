package com.sl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sl.entity.Student;
import com.sl.repositry.StudentRepositry;

@RestController
@RequestMapping("/student")
public class StudentRestController {
	
	@Autowired
	StudentRepositry studentRepositry;

	/* List all students */
	@GetMapping("/list")
	public List<Student> listAllStudents() {

		List<Student> students = studentRepositry.findAll();
		
		return students;
	}
	
	/* Create a student */
	@PostMapping("/add-student")
	public Student createStudent(@RequestBody Student stud) {
		
		Student createdStudent  = studentRepositry.save(stud);
		
		return createdStudent;
	}

}

