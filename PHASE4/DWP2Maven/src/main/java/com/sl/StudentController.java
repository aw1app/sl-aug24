package com.sl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@PostMapping("/student-registration")
	public String studentRegistration(ModelMap model,
			@RequestParam("firstName") String firstName,
			@RequestParam("sessionName") String sessionName) {
		
		
		
		model.addAttribute("fN", firstName);
		model.addAttribute("sessName", sessionName);
		
		return "student-registration-success"; // render student-registration-success.jsp in the views folder
	}
	
	@GetMapping("/path1")
	@ResponseBody
	public String path1() {
		// Business logic
		return "<h1>hello from StudentController path1!</h1>";
	}

}
