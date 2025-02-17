package com.visilean.commons;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

	public String dailyWorkOut() {
		return "Practice cover drive for 15 min";
	}

}