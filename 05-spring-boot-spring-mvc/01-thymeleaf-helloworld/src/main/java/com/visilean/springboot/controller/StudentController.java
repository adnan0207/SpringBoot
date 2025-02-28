package com.visilean.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.visilean.springboot.model.Student;

@Controller
public class StudentController {

	@GetMapping("/showStudentForm")
	public String showForm(Model model) {
		
		// create student object
		Student stuObj = new Student();
		
		// adding student object to model
		model.addAttribute("student", stuObj);
		
		return "student-form";
	}
	
	@PostMapping("/processStudentForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		// log the input data
		System.out.println("The student : " + theStudent.getFirstName() + " " + theStudent.getLastName() + " " + theStudent.getCountry());
		
		return "student-confirmation";
		
	}
}
