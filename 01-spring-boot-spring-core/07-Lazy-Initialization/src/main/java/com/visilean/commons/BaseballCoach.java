package com.visilean.commons;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BaseballCoach implements Coach {

	public BaseballCoach() {
		System.out.println("In Constructor of : " + getClass().getSimpleName());
	}

	public String dailyWorkOut() {
		return "Practice bat swing for 20 min";
	}

}