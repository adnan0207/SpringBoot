package com.visilean.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.visilean.commons.Coach;
import com.visilean.commons.SwimmingCoach;

@Configuration
public class SportConfig {
	
	@Bean("aquatic")  // adding custom bean id
	public Coach getSwimmingCoachObject() {
		return new SwimmingCoach();
	}

}
