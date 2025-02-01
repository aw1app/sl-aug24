package com.sl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProjectMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Constructor Injection Demo
		Product p1 = (Product) context.getBean("product1");

		System.out.println("Product p1's name is " + p1.getName());
		System.out.println("Product p1's price is " + p1.getPrice());

		// Property setter Injection Demo
		Product prod2 = (Product) context.getBean("product2");

		System.out.println("Product prod2's name is " + prod2.getName());
		System.out.println("Product prod2's price is " + prod2.getPrice());

	}

}
