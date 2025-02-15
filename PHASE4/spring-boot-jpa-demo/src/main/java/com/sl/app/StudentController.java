package com.sl.app;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

	@Autowired
	StudentRepositry studentRepositry;

	/* List all students */
	@GetMapping("/list")
	public String listAllStudents(Model model) {

		List<Student> students = studentRepositry.findAll();

		model.addAttribute("students", students);

		return "list-students";
	}

	/* List details of a single student */
	@GetMapping("/details")
	public String getStudent(Model model, @RequestParam(name = "id") int id) {

		Optional<Student> optionalStudent = studentRepositry.findById(id);

		if (optionalStudent.isPresent()) {

			Student student = optionalStudent.get();

			model.addAttribute("student", student);
		} else {
			model.addAttribute("student", null);
		}

		return "detail-student";
	}

	/* Create a student */
	@GetMapping("/add-student")
	public String addStudentShowForm(Model model) {
		
		Student student = new Student();
		model.addAttribute("student", student);

		return "add-student"; // goes to add-student.jsp in the views folder

	}
	
	@PostMapping("/add-student")
	public String addStudent(Model model, @ModelAttribute("student") Student student) {
		Student createdStudent = studentRepositry.save(student);
		
		model.addAttribute("studentId", createdStudent.getStudentId());
		
		return "add-student-success";
	}
	
	/* Delete a student */

}
