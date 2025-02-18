package com.visilean.cruddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.visilean.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;

@Repository
public class StudentDAOImple implements StudentDAO {

	// defining field for entity manager

	EntityManager entityManager;

	// injecting entity manager using constructor injection

	@Autowired
	public StudentDAOImple(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	// implementing save method

	@Transactional
	public void save(Student student) {
		entityManager.persist(student);
	}

	public Student findById(int id) {
		return entityManager.find(Student.class, id);
	}

}
