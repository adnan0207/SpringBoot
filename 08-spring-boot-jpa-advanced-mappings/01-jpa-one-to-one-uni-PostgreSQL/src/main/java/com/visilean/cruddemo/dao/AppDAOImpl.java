package com.visilean.cruddemo.dao;

import com.visilean.cruddemo.entity.Instructor;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

public class AppDAOImpl implements AppDAO{

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


}
