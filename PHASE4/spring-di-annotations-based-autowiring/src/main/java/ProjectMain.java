

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan({"com.sl"})
public class ProjectMain {
	@Autowired
	static Product p1;
	
	

	public static void main(String[] args) {
		
		
		System.out.println("Product p1's name is " + p1.getName());
		System.out.println("Product p1's desc is " + p1.getDesc());
		System.out.println("Product p1's price is " + p1.getPrice());		
		

	}

}
