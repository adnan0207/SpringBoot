package com.visilean.springboot.service;

import java.util.List;

import com.visilean.springboot.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}
