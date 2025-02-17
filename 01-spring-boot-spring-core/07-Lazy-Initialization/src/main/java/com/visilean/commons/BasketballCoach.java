package com.visilean.commons;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BasketballCoach implements Coach {

	public BasketballCoach() {
		System.out.println("In Constructor of : " + getClass().getSimpleName());
	}

	public String dailyWorkOut() {
		return "Practice dribbling for 10 min";
	}

}