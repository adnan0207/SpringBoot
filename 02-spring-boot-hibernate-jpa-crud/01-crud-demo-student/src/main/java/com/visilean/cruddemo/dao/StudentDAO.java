package com.visilean.cruddemo.dao;

import java.util.List;

import com.visilean.cruddemo.entity.Student;

public interface StudentDAO {
	
	void save (Student student);
	
	Student findById(int id);
	
	List<Student> findAll();

	List<Student> findByLastName(String lastName);
	
	void update(Student student);

}
