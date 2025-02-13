package com.visilean.commons;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

	public String dailyWorkOut() {
		return "Practice bat swing for 20 min";
	}

}