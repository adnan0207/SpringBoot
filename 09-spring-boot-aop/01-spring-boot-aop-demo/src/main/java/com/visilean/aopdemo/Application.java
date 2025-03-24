package com.visilean.aopdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.visilean.aopdemo.dao.AccountDAO;
import com.visilean.aopdemo.dao.MembershipDAO;
import com.visilean.aopdemo.entity.Account;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		return runner -> {
			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
		};

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
