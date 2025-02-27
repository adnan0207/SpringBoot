package com.visilean.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	// mapping for /hello
	
	@GetMapping("/hello")
	public String helloWorld(Model theModel) {
		
		theModel.addAttribute("theDate", java.time.LocalDateTime.now());
		
		return "helloworld";
		
		// since we have the Thymeleaf dependency in the Maven POM File 
		// Spring Boot will auto-configure to use Thymeleaf

		// So when we return helloworld
		// it's gonna look in source/main/resources/templates for a helloworld.html
	}

}
