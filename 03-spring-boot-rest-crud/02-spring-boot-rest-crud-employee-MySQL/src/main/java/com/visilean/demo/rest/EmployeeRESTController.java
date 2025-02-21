package com.visilean.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.visilean.demo.entity.Employee;
import com.visilean.demo.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/api")
public class EmployeeRESTController {

	private EmployeeServiceImpl empSer;

	public EmployeeRESTController(EmployeeServiceImpl empSer) {
		this.empSer = empSer;
	}

	// REST end point

	@GetMapping("/employees")
	public List<Employee> getAllEmp() {
		return empSer.findAll();
	}

}
