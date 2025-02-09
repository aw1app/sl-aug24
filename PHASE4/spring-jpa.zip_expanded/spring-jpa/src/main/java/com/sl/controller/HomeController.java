package com.sl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	
	@GetMapping("/home")
	@ResponseBody
	public String sayHello() {
		return "Hello, Hi";
	}

}
