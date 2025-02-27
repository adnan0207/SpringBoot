package com.visilean.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

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
	
	
	// need a controller method to read the form data and add that data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShout(HttpServletRequest req, Model model) {
		// read the request parameter from the HTML form
		String theName = req.getParameter("name");
		
		// convert data to all caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Yo! " + theName;
		
		// add the message to model
		model.addAttribute("message", result);
		
		return "nameOutputVersionTwo";
	}
	
	
	
}
