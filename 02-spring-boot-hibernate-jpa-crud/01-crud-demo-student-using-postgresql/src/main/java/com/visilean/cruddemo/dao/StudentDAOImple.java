package com.visilean.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.visilean.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

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

	public List<Student> findAll() {
		TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s", Student.class);
//		TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s ORDER BY s.lastName", Student.class);
//		TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s ORDER BY s.lastName DESC", Student.class);
		return query.getResultList();
	}

	public List<Student> findByLastName(String lastname) {
		TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s WHERE s.lastName = :theData", Student.class);
		query.setParameter("theData", lastname);
		return query.getResultList();
	}

	@Transactional
	public void update(Student student) {
		entityManager.merge(student);
	}

	@Transactional
	public void delete(int id) {
		Student studentToDelete = entityManager.find(Student.class, id);
		entityManager.remove(studentToDelete);
	}

}
