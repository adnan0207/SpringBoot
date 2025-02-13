package com.visilean.commons;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary			// set this one as a primary bean
public class BaseballCoach implements Coach {

	public String dailyWorkOut() {
		return "Practice bat swing for 20 min";
	}

}