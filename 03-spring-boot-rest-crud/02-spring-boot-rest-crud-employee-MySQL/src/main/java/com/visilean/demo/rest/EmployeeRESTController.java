package com.visilean.demo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.visilean.demo.dao.EmployeeDAOImpl;
import com.visilean.demo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRESTController {

	private EmployeeDAOImpl empDAO;

	public EmployeeRESTController(EmployeeDAOImpl empDAO) {
		this.empDAO = empDAO;
	}

	// REST end point

	@GetMapping("/employees")
	public List<Employee> getAllEmp(){
		return empDAO.findAll();
	}

}
