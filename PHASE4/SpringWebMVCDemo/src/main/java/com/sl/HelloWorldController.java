package com.sl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {

		return "hello :Hi there";
	}
	
	@GetMapping("/hello2")
	@ResponseBody
	public String hello2() {

		return "hello from hello 2";
	}

}
