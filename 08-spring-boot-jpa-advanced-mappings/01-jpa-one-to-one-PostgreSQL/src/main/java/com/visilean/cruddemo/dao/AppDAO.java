package com.visilean.cruddemo.dao;

import com.visilean.cruddemo.entity.Instructor;
import com.visilean.cruddemo.entity.InstructorDetail;

public interface AppDAO {

	public void save(Instructor theInstructor);

	public Instructor findInstructorById(int theId);

	public void deleteInstructorByID(int theId);

	public InstructorDetail findInstructorDetailById(int theId);

}
