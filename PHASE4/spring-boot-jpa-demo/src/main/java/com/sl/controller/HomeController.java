package com.sl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	
	@GetMapping("/hello")
	@ResponseBody
	public String sayHello() {
		return "Hello";
	}
	
	
	@GetMapping("/hi")
	@ResponseBody
	public String sayHi() {
		return "Hi";
	}
	
	@GetMapping("/A")
	public String gotoAdotJSP() {
		return "a"; // render a.jsp in /WEB-INF/views/ folder
	}

}