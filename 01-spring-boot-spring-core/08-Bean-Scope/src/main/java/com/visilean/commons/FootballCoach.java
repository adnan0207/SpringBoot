package com.visilean.commons;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

	public String dailyWorkOut() {
		return "Practice penalty shoot for 30 min";
	}

}