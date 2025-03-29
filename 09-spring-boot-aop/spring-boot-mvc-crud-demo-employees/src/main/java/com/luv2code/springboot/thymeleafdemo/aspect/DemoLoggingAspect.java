package com.luv2code.springboot.thymeleafdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

	// setup logger
	private Logger classNameLogger = Logger.getLogger(getClass().getName());
	
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
	@Pointcut("forControllerPackage || forServicePackage || forDAOPackage")
	private void forAppFlow() {
	}
	
}
