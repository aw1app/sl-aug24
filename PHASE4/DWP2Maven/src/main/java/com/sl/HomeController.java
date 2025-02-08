package com.sl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/seller")
public class HomeController {
	
	@GetMapping("/path1*")
	@ResponseBody
	public String path1() {
		// Business logic
		return "<h1>hello from path1!</h1>";
	}
	
	@GetMapping("/path2")
	public String path2() {
		// Business logic
		// Create the model and pass that to the view
		return "b"; // render b.jsp in the views folder
	}
	
	@RequestMapping(name="/path2", method = RequestMethod.POST)
	public String path3() {
		// Business logic
		// Create the model and pass that to the view
		return "b"; // render b.jsp in the views folder
	}
	
	@PostMapping("/path4")
	public String path4() {
		// Business logic
		// Create the model and pass that to the view
		return "b"; // render b.jsp in the views folder
	}
	
	// 
	
	
	

}
