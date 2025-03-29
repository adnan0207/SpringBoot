package com.luv2code.springboot.thymeleafdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
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
	}
	
}
