package com.visilean.aopdemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.visilean.aopdemo.dao.AccountDAO;
import com.visilean.aopdemo.dao.MembershipDAO;
import com.visilean.aopdemo.entity.Account;
import com.visilean.aopdemo.service.TrafficFortuneService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO, TrafficFortuneService theTrafficFortuneService) {

		return runner -> {
//			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
//			demoTheAfterReturningAdvice(theAccountDAO);
//			demoTheAfterThrowingAdvice(theAccountDAO);
//			demoTheAfterAdvice(theAccountDAO);
			demoTheAroundAdvice(theTrafficFortuneService);
		};

	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {
		System.out.println("\n Main Program : demoTheAroundAdvice");
		System.out.println("Calling getFortune method");
		String fortune = theTrafficFortuneService.getFortune();
		System.out.println("\n My fortune is : " + fortune);
		System.out.println("Finished");
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		
		// call method to find the account
		List<Account> theAccounts = null;
		
		try {
			// adding a boolean as true to throw exception
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);
			
		} catch (Exception exc) {
			System.out.println("\n\n Main Program : caught exception " + exc);
		}
		
		// display the accounts
		System.out.println("\n\n Main Program : demoTheAfterThrowingAdvice");
		System.out.println("---------------");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		
		// call method to find the account
		List<Account> theAccounts = null;
		
		try {
			// adding a boolean to throw exception
			boolean tripWire = true;
			theAccounts = theAccountDAO.findAccounts(tripWire);
			
		} catch (Exception exc) {
			System.out.println("\n\n Main Program : caught exception " + exc);
		}
		
		// display the accounts
		System.out.println("\n\n Main Program : demoTheAfterThrowingAdvice");
		System.out.println("---------------");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
		
		// call method to find the account
		List<Account> theAccounts = theAccountDAO.findAccounts();
		
		// display the accounts
		System.out.println("\n\n Main Program : demoTheAfterReturningAdvice");
		System.out.println("---------------");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		// call the business model
		Account myAccount = new Account();
		myAccount.setName("Adnan");
		myAccount.setLevel("Gold");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();
		
		// calling the account DAO getter and setter methods
		theAccountDAO.setName("hehehehe");
		theAccountDAO.setServiceName("hoohoohoohoo");
		
		theAccountDAO.getName();
		theAccountDAO.getServiceName();
		
		// call the membership business model
		theMembershipDAO.addMember();
		theMembershipDAO.goToSleep();
	}

}
