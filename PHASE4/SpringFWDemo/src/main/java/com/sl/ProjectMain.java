package com.sl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProjectMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Constructor Injection Demo
		IProduct p1 = (IProduct) context.getBean("product1");

		System.out.println("Product p1's name is " + p1.getName());
		System.out.println("Product p1's desc is " + p1.getDesc());
		System.out.println("Product p1's price is " + p1.getPrice());

		// Property setter Injection Demo
		IProduct prod2 = (IProduct) context.getBean("product2");

		System.out.println("Product prod2's name is " + prod2.getName());
		System.out.println("Product prod2's price is " + prod2.getPrice());
		
		
		//Heirarchy Demo
		System.out.println("Heirarchy Demo");
		IProduct prod3 = (IProduct) context.getBean("product3");
		System.out.println("Product prod3's name is " + prod3.getName());
		System.out.println("Product prod3's price is " + prod3.getPrice());
		System.out.println("Product prod3's brand name  is " + prod3.getBrand().getName());
		

	}
	
	
	
}


