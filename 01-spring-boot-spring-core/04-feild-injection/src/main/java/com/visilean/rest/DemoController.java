package com.visilean.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.visilean.commons.Coach;

@RestController
public class DemoController {

	// feild injection
	@Autowired
	private Coach myCoach;

	@GetMapping("/getDailyWorkout")
	public String getDailyWorkout() {
		return myCoach.dailyWorkOut();
	}

}