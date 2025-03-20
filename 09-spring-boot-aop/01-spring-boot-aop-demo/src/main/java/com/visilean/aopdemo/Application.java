package com.visilean.aopdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.visilean.aopdemo.dao.AccountDAO;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO) {

		return runner -> {
			demoTheBeforeAdvice(theAccountDAO);
		};

	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO) {

		// call the business model
		theAccountDAO.addAccount();
		System.out.println("\n Calling it again");
		theAccountDAO.addAccount();
	}

}
