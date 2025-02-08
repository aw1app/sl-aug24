package com.sl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sl.dao.StudentDAO;
import com.sl.entity.Student;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	StudentDAO studentDAO;
	
	
	@GetMapping("/listStudents")
	public String getStudents(Model model) {
		
		//Business logic
		List<Student> students = studentDAO.getAllStudents();
		
		model.addAttribute("students", students);
		
		return "list-students"; // display list-students.jsp
	}

	

}
