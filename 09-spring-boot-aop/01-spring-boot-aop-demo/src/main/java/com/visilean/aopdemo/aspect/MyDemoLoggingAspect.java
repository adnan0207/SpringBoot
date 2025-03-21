package com.visilean.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all the advises for logging
	
	// @Before advice
	
//	 For param-pattern
//	 () - matches a method with no arguments
//	 (*) - matches a method with one argument of any type
//	 (..) - matches a method with 0 or more arguments of any type
	
	// public (*)->return type (com.visilean.aopdemo.dao)->package name . (*)->any class . (*)->any method ((..))->any param
	
	@Pointcut("execution(public * com.visilean.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n ====> Executing @Before advice on method");
	}
}
