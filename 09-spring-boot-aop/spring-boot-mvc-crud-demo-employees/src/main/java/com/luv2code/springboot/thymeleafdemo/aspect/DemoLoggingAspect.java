package com.luv2code.springboot.thymeleafdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// setup pointcut declarations
	@Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..) )")
	private void forControllerPackage() {
	}

	@Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..) )")
	private void forServicePackage() {
	}
	
	@Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..) )")
	private void forDAOPackage() {
	}

	// combining them
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {
	}
	
	// adding before advice 
	
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		// display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("===> in @Before : calling the method : " + theMethod);
		// display the arguments to the method
		// get the arguments
		Object[] args = theJoinPoint.getArgs();
		// loop through and display them
		for(Object tempArgs : args) {
			myLogger.info("===> argument : " + tempArgs);
		}
	}
	
	// add after returning advice 
	
	@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("===> in @AfterReturning : calling the method : " + theMethod);
		// display the data returned
		myLogger.info("===> result : " + theResult);
		
	}
	
}
