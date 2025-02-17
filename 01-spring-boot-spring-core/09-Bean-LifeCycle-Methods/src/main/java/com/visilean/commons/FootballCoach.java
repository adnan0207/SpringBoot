package com.visilean.commons;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class FootballCoach implements Coach {

	public String dailyWorkOut() {
		return "Practice penalty shoot for 30 min";
	}

	@PostConstruct
	public void doMyStartUpStuff() {
		System.out.println("This is my start up stuff " + getClass().getSimpleName());
	}
	
	@PreDestroy
	public void doMyShutDownStuff() {
		System.out.println("This is my shut down stuff " + getClass().getSimpleName());
	}
}