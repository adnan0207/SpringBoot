package com.visilean.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.visilean.demo.dao.EmployeeDAOImpl;
import com.visilean.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAOImpl empDAO;

	public EmployeeServiceImpl(EmployeeDAOImpl empDAO) {
		this.empDAO = empDAO;
	}

	public List<Employee> findAll() {
		return empDAO.findAll();
	}

}
