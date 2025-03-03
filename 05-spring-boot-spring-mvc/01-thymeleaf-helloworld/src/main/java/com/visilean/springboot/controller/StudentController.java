package com.visilean.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.visilean.springboot.model.Student;

@Controller
public class StudentController {
	
	@Value("${countries}")
	List<String> listOfCountries;

	@Value("${languages}")
	List<String> listOfProgrammingLanguages;

	@GetMapping("/showStudentForm")
	public String showForm(Model model) {
		
		// create student object
		Student stuObj = new Student();
		
		// adding student object to model
		model.addAttribute("student", stuObj);
		
		// adding list of countries to the model
		model.addAttribute("countries", listOfCountries);

		// adding list of languages to the model
		model.addAttribute("languages", listOfProgrammingLanguages);
		
		return "student-form";
	}
	
	@PostMapping("/processStudentForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		// log the input data
		System.out.println("The student : " + theStudent.getFirstName() + " " + theStudent.getLastName() + " " + theStudent.getCountry()
							+ " " + theStudent.getProgrammingLanguage() + " " + theStudent.getFavoriteSystems());
		
		return "student-confirmation";
		
	}
}
