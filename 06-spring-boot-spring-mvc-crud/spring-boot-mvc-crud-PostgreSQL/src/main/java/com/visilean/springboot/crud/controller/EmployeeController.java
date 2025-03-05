package com.visilean.springboot.crud.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.visilean.springboot.crud.entity.Employee;
import com.visilean.springboot.crud.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		// get the employees from the database
		
		List<Employee> theEmployees = employeeService.findAll();
		
		// add to the spring model
		
		theModel.addAttribute("employees", theEmployees);
		
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind the data
		
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		// save the employee
		
		employeeService.save(theEmployee);
		
		// use a redirect to prevent duplicate submission
		
		return "redirect:/employees/list";
	}
	

}
