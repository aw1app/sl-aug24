

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.sl.BankAccount;
import com.sl.Main;

@Configuration
//@ComponentScan({"com.sl"})
public class ProjectMain {
	
	
	

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectMain.class);
		
		Product p1 = (Product) context.getBean(Product.class);
		
		System.out.println("Product p1's name is " + p1.getName());
		System.out.println("Product p1's desc is " + p1.getDesc());
		System.out.println("Product p1's price is " + p1.getPrice());		
		

	}

}
