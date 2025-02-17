package com.visilean.commons;

import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach {

	public BasketballCoach() {
		System.out.println("In Constructor of : " + getClass().getSimpleName());
	}

	public String dailyWorkOut() {
		return "Practice dribbling for 10 min";
	}

}