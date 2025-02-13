package com.visilean.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.visilean.commons.Coach;

@RestController
public class DemoController {

	// private field for the setter
	private Coach myCoach;

	// define a setter method for dependency injection
	@Autowired
	public void setCoach(Coach theCoach) {
		myCoach = theCoach;
	}
	
	@GetMapping("/getDailyWorkout")
	public String getDailyWorkout() {
		return myCoach.dailyWorkOut();
	}

}