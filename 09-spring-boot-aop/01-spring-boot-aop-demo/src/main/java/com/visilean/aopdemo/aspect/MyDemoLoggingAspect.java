package com.visilean.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all the advises for logging
	
	// @Before advice
	
	@Before("execution(public void add*())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n ====> Executing @Before advice on method");
	}
}
