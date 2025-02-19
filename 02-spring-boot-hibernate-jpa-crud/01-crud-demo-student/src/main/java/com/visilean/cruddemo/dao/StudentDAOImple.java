package com.visilean.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.visilean.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImple implements StudentDAO{

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

	// implementing find by id method
	
	public Student findById(int id) {
		return entityManager.find(Student.class, id);
	}

	// implementing find all student method
	public List<Student> findAll() {
		TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
//		TypedQuery<Student> query = entityManager.createQuery("FROM Student order by lastName", Student.class);
//		TypedQuery<Student> query = entityManager.createQuery("FROM Student order by lastName desc", Student.class);
		List<Student> resultList = query.getResultList();
		return resultList;
	}

	public List<Student> findByLastName(String lastName) {
		// creating Query
		TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName = :theData", Student.class);
		// setting query parameter
		query.setParameter("theData", lastName);
		// returning result
		return query.getResultList();
	}

}
