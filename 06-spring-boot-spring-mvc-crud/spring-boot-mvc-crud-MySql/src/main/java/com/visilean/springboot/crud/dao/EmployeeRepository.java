package com.visilean.springboot.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visilean.springboot.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
