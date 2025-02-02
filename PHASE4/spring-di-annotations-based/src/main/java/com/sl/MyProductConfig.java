package com.sl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyProductConfig {
	
	@Bean(name = "product1")
	public Product createProduct() {
		
		Product p = new Product();
		p.setName("Dell Laptop");
		p.setPrice(50000.0f);
		
		return p;		
	}
	
	@Bean(name = "product2")
	public Product createProduct2() {
		
		Product p = new Product();
		p.setName("HP Laptop");
		p.setPrice(55550.0f);
		
		return p;		
	}

}
