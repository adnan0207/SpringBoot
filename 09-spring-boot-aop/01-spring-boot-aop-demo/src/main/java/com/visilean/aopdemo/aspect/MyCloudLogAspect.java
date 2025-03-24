package com.visilean.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAspect {

	@Before("com.visilean.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void logToCloud() {
		System.out.println(" ====> Logging to Cloud");
	}
}
