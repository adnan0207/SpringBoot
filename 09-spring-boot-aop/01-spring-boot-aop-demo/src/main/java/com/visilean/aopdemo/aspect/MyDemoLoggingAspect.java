package com.visilean.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.visilean.aopdemo.entity.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	@Before("com.visilean.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println(" ====> Executing @Before advice on method");

		// display the method signature
		MethodSignature methodSignature = (MethodSignature)theJoinPoint.getSignature();
		System.out.println("Method : " + methodSignature);
		
		// display method arguments
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop through args
		for(Object tempArg : args) {
			System.out.println(tempArg);
			if(tempArg instanceof Account) {
				Account theAcc = (Account)tempArg;
				System.out.println("Account name : " + theAcc.getName() + " & Account level : " + theAcc.getLevel());
			}
		}
	}
}
