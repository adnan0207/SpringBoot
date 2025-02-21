package com.visilean.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.visilean.demo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	// define field for entity manager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Employee> findAll() {

		// create a query
		TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);

		// execute the query
		List<Employee> resultList = query.getResultList();

		// return the result
		return resultList;
	}

	public Employee findById(int theID) {
		// get employee
		Employee employee = entityManager.find(Employee.class, theID);

		// return employee
		return employee;
	}

	public Employee save(Employee emp) {
		// save the employee
		// if id == 0 then it will be added as a new employee and if some id is given then it will update accordingly
		// this method will do the work of both save and update
		Employee dbEmp = entityManager.merge(emp);

		// return the database employee
		return dbEmp;
	}

	public void delete(int theID) {
		// find employee by id
		Employee employee = entityManager.find(Employee.class, theID);

		// remove the employee
		entityManager.remove(employee);

	}
}
