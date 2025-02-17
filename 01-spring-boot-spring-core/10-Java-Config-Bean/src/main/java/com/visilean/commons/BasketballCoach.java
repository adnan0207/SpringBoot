package com.visilean.commons;

import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach {

	public String dailyWorkOut() {
		return "Practice dribbling for 10 min";
	}

}