package com.visilean.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.visilean.spring.utils.Coach;

@RestController
public class DemoController {

	// private field for the constructor
	private Coach myCoach;

	// define a constructor for dependency injection
	@Autowired
	public DemoController(Coach theCoach) {
		this.myCoach = theCoach;
	}

	@GetMapping("/getDailyWorkout")
	public String getDailyWorkout() {
		return myCoach.dailyWorkOut();
	}

}
