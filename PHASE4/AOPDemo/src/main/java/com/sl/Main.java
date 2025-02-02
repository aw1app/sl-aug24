package com.sl;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("com.sl")
@Configuration
@EnableAspectJAutoProxy
public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
		
		BankAccount bankAcct = (BankAccount) context.getBean(BankAccount.class);
		
		bankAcct.deposit(10000.0d);

	}

}
