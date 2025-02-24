package com.visilean.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visilean.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
