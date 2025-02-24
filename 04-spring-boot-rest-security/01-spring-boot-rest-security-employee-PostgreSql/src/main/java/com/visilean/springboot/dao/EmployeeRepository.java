package com.visilean.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visilean.springboot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!

}
