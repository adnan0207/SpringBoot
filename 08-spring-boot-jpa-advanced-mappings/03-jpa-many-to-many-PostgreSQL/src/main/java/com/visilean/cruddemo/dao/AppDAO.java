package com.visilean.cruddemo.dao;

import java.util.List;

import com.visilean.cruddemo.entity.Course;
import com.visilean.cruddemo.entity.Instructor;
import com.visilean.cruddemo.entity.InstructorDetail;
import com.visilean.cruddemo.entity.Student;

public interface AppDAO {

	public void save(Instructor theInstructor);

	public Instructor findInstructorById(int theId);

	public void deleteInstructorByID(int theId);

	public InstructorDetail findInstructorDetailById(int theId);
	
	public void deleteInstructorDetailByID(int theId);
	
	public List<Course> findCoursesByInstructorId(int theId);
	
	public Instructor findInstructorByIdJoinFetch(int theId);
	
	public void update(Instructor instructor);

	public void update(Course course);
	
	public Course findCourseById(int theId);
	
	public void deleteCourseById(int theId);
	
	public void save(Course theCourse);
	
	public Course findCourseAndReviewsByCourseId(int theId);
	
	public Course findCourseAndStudentsByCourseId(int theId);

	public Student findStudentAndCoursesByStudentId(int theId);

}
