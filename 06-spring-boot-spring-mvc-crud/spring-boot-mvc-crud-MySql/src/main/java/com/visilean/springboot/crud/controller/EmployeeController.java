package com.visilean.springboot.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.visilean.springboot.crud.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

}
