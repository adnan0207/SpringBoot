package com.visilean.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	@Around("execution(* com.visilean.aopdemo.service.*.getFortune(..))")
	public Object aroundAdviceGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		// print out the method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n ===> Executing @Around on method : " + method);
		
		// get begin timestamp
//		long begin = System.currentTimeMillis();
		long begin = System.nanoTime();
		
		// execute the method
		Object result = null;
		
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception exc) {
			// log the exception
			System.out.println(exc.getMessage());
			
			// rethrow exception
			throw exc;
		}
		
		// get end timestamp
//		long end = System.currentTimeMillis();
		long end = System.nanoTime();
		
		// get the duration and display it
		long duration = end - begin;
		System.out.println("\n =====> Duration = " + duration + " nanoseconds");
		
		return result;
	}
	
	@After("execution(* com.visilean.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n ===> Executing @After (finally) on method : " + method);
		
	}
	
	@AfterThrowing(pointcut = "execution(* com.visilean.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n ===> Executing @AfterThrowing on method : " + method);
		
		// log the exception 
		System.out.println("\n ===> The exception : " + theExc);
	}
	
	@AfterReturning(pointcut = "execution(* com.visilean.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n ===> Executing @AfterReturning on method : " + method);
		
		// print out the result of the method call
		System.out.println("\n ===> The result : " + result);
		
		// let's post-process the data... let's modify it
		// convert the account names to upper case
		convertAccountNamesToUpperCase(result);

		System.out.println("\n ===> The result : " + result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		// loop through the accounts
		for(Account acc : result) {
			// get upper case versions of name
			String upperName = acc.getName().toUpperCase();

			// update the name on the account
			acc.setName(upperName);
		}
		
	}

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
