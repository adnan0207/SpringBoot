package com.visilean.commons;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

	public FootballCoach() {
		System.out.println("In Constructor of : " + getClass().getSimpleName());
	}

	public String dailyWorkOut() {
		return "Practice penalty shoot for 30 min";
	}

}