package com.visilean.cruddemo.dao;

import org.springframework.stereotype.Repository;

import com.visilean.cruddemo.entity.Instructor;
import com.visilean.cruddemo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImpl implements AppDAO {

	// define field for entity manager
	private EntityManager entityManager;

	// inject entity manager using constructor injection
	public AppDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Instructor theInstructor) {
		entityManager.persist(theInstructor);
	}

	@Override
	public Instructor findInstructorById(int theId) {
		return entityManager.find(Instructor.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstructorByID(int theId) {
		// retrieve the instructor
		Instructor tempInstructor = entityManager.find(Instructor.class, theId);

		// delete the instructor
		entityManager.remove(tempInstructor);
	}

	@Override
	public InstructorDetail findInstructorDetailById(int theId) {
		return entityManager.find(InstructorDetail.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstructorDetailByID(int theId) {
		// retrieve the instructor detail
		InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);
		
		// delete the instructor detail
		entityManager.remove(tempInstructorDetail);
	}

}
