package com.adnan.utils;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

	public String dailyWorkOut() {
		return "Practice fast bowling for 15 min";
	}

}
