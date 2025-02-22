import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class UIController{
	
	
	// Connect to the courses micro service
	// using RestTemplate
	
	@Autowired
    private RestTemplate restTemplate;
	
	@GetMapping("/display-courses")
	public String displayAllCourses(Model model) {
		
		List<Course> courses = restTemplate.exchange(
				"http://localhost:8081/courses/all", 
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Course>>()  {}
				).getBody();
		
		model.addAttribute("courses", courses);
		
		return "courses"; // courses.jsp
		
	}
	
	
}