package com.visilean.springboot.crud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visilean.springboot.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	// add a method to sort by first name
	public List<Employee> findAllByOrderByFirstNameAsc();

}
