package com.sl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.sl.dao.StudentDAO;
import com.sl.entity.Student;


@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentDAO studentDAO;

	@GetMapping("/listStudents")
	public String getStudents(Model model) {

		// Business logic
		List<Student> students = studentDAO.getAllStudents();

		model.addAttribute("students", students);

		return "list-students"; // display list-students.jsp
	}
	
	
	
//	@GetMapping("/hello")
//	@ResponseBody
//	public String sayHello() {
//		
//		return "hi";
//	}
//
//	@GetMapping(value="/records", produces = "application/json")
//	@ResponseBody
//	public Map<String, String> getRecords() {
//		HashMap<String, String> map = new HashMap<>();
//		map.put("key", "value");
//		map.put("foo", "bar");
//		map.put("aa", "bb");
//
//		return map;
//	}

}
