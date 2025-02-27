package com.visilean.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloFormController {

	// method to show html form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "nameInputForm";
	}
	
	// method to process html form
	@RequestMapping("/processForm")
	public String processForm() {
		return "nameOutputForm";
	}
	
}
