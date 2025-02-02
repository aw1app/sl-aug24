package com.sl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;


public class ProjectMain {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyProductConfig.class);
		
		Product p1 = (Product) context.getBean("product1");

		System.out.println("Product p1's name is " + p1.getName());
		System.out.println("Product p1's desc is " + p1.getDesc());
		System.out.println("Product p1's price is " + p1.getPrice());
		
		
		Product p2 = (Product) context.getBean("product2");

		System.out.println("Product p2's name is " + p2.getName());
		System.out.println("Product p2's desc is " + p2.getDesc());
		System.out.println("Product p2's price is " + p2.getPrice());
		
		Product p3 = (Product) context.getBean("product3");

		System.out.println("Product p3's name is " + p3.getName());
		System.out.println("Product p3's desc is " + p3.getDesc());
		System.out.println("Product p3's price is " + p3.getPrice());
		System.out.println("Product p3's brand is " + p3.getBrand().getName());

	}

}
