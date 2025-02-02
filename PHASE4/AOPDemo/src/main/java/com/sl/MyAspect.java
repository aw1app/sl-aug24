package com.sl;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

	// only com.sl.BankAccount's any of the methods
	@Before("execution(* com.sl.BankAccount.*(..))")
	public void m1() {

		System.out.println(" (LOG) Hi, this is an Before type INTERCEPTOR/ADVICE ");

	}

	// for any class and any method inside com.sl package
	@After("execution(* com.sl.*.*(..))")
	public void m2() {

		System.out.println(" (LOG) Hi, this is an After type INTERCEPTOR/ADVICE ");

	}

	@AfterReturning(pointcut = "execution(* com.sl.BankAccount.withdraw(..))", returning = "result")
	public void m3(double result) {

		if (result >= 5000)
			System.out.println("(LOG) Hi, this is an After Returtning type INTERCEPTOR/ADVICE " + " Amount " + result
					+ " was withdrawn!");
	}
	
	// Challenge : How will you measure performance (execution time) of your methods in BankAccount.
	// Implement Around and for Exceptions thrown in methods of BankAccount.

}
