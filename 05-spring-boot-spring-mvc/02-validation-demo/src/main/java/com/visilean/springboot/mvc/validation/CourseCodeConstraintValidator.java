package com.visilean.springboot.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{

	private String coursePrefix;
	
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}


	// spring mvc will call isValid
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
		boolean result = theCode.startsWith(coursePrefix);
		return result;
	}
	

}
