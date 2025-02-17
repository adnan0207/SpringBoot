package com.visilean.commons;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // set this one as a primary bean
public class CricketCoach implements Coach {

	public CricketCoach() {
		System.out.println("In Constructor of : " + getClass().getSimpleName());
	}

	public String dailyWorkOut() {
		return "Practice cover drive for 15 min";
	}

}