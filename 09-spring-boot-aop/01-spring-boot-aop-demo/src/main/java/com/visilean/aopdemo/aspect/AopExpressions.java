package com.visilean.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect 			// if you only have pointcut expressions then using @Aspect is optional
public class AopExpressions {

//	 For param-pattern
//	 () - matches a method with no arguments
//	 (*) - matches a method with one argument of any type
//	 (..) - matches a method with 0 or more arguments of any type

	// public (*)->return type (com.visilean.aopdemo.dao)->package name . (*)->any
	// class . (*)->any method ((..))->any param

	@Pointcut("execution(public * com.visilean.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {
	}

	// create a pointcut for getter method
	@Pointcut("execution(public * com.visilean.aopdemo.dao.*.get*(..))")
	public void forGetters() {
	}

	// create a pointcut for setter method
	@Pointcut("execution(public * com.visilean.aopdemo.dao.*.set*(..))")
	public void forSetters() {
	}

	// create a pointcut to include the package and exclude the getter/setter
	@Pointcut("forDaoPackage() && !(forGetters() || forSetters() )")
	public void forDaoPackageNoGetterSetter() {
	}
}
