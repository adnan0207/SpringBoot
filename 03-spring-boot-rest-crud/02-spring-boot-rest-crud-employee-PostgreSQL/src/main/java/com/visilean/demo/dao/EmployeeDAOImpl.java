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

}
