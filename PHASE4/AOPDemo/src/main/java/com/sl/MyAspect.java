package com.sl;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	@Before("execution(* com.sl.BankAccount.*(..))")
	public void m1() {

		System.out.println(" (LOG) Hi, this is an Before type INTERCEPTOR/ADVICE ");

	}

}
