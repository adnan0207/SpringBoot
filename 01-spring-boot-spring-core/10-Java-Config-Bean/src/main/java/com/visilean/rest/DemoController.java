package com.visilean.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.visilean.commons.Coach;

@RestController
public class DemoController {

	// private field for the constructor
	private Coach myCoach;

	// define a constructor for dependency injection
	@Autowired
	public DemoController(@Qualifier("aquatic") Coach theCoach) {  // Qualifier takes bean id
		this.myCoach = theCoach;
	}

	@GetMapping("/getDailyWorkout")
	public String getDailyWorkout() {
		return myCoach.dailyWorkOut();
	}

}