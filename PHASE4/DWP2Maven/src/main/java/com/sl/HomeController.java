package com.sl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@GetMapping("/path1")
	@ResponseBody
	public String path1() {

		return "<h1>hello from path1!</h1>";
	}
	
	@GetMapping("/path2")
	public String path2() {

		return "b"; // render b.jsp in the views folder
	}
	
	

}
