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
	
	// create a pointcut for getter method
	@Pointcut("execution(public * com.visilean.aopdemo.dao.*.get*(..))")
	private void forGetters() {
	}
	
	// create a pointcut for setter method
	@Pointcut("execution(public * com.visilean.aopdemo.dao.*.set*(..))")
	private void forSetters() {
	}
	
	// create a pointcut to include the package and exclude the getter/setter
	@Pointcut("forDaoPackage() && !(forGetters() || forSetters() )")
	private void forDaoPackageNoGetterSetter() {
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n ====> Executing @Before advice on method");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println(" ====> performing API analytics");
	}

	@Before("forDaoPackageNoGetterSetter()")
	public void logToCloud() {
		System.out.println(" ====> Logging to Cloud");
	}
}
