package com.visilean.demo.dao;

import java.util.List;

import com.visilean.demo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
	Employee findById(int theID);
	
	Employee save(Employee emp);
	
	void delete(int theID);

}
