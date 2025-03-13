package com.visilean.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.visilean.cruddemo.dao.AppDAO;
import com.visilean.cruddemo.entity.Course;
import com.visilean.cruddemo.entity.Instructor;
import com.visilean.cruddemo.entity.InstructorDetail;
import com.visilean.cruddemo.entity.Review;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			createCourseAndReviews(appDAO);
//			retrieveCourseAndReviews(appDAO); 
			deleteCourseAndReviews(appDAO);
		};
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId = 11;
		System.out.println("Deleting course with id : " + theId);
		
		// this will delete the course as well as reviews also cause we have cascade type all
		appDAO.deleteCourseById(theId);
		
		System.out.println("DONE!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		// get course and reviews
		int theId = 11;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);
		
		// print the course
		System.out.println(tempCourse);
		
		// print the review
		System.out.println(tempCourse.getReviews());
		
		System.out.println("DONE!");
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		// create a course
		Course tempCourse = new Course("Pacman - How to beat the game");
		
		// add some reviews
		tempCourse.addReview(new Review("Great course, I won on my first try"));
		tempCourse.addReview(new Review("Best course, Loved it"));
		tempCourse.addReview(new Review("Bad, you are an idiot"));
		
		// save the course
		// just saving the course will automatically save the reviews also cause we are using cascade all
		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		
		appDAO.save(tempCourse);
		
		System.out.println("DONE!");
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;
		
		System.out.println("Deleting course with id : " + theId);
		
		appDAO.deleteCourseById(theId);
		
		System.out.println("DONE!");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 10;
		
		// finding the course
		System.out.println("Finding course with id : " + theId);
		Course tempCourse = appDAO.findCourseById(theId);
		
		// update the course
		System.out.println("Updating the course with id : " + theId);
		
		tempCourse.setTitle("DevOps INTRODUCTION");
		
		appDAO.update(tempCourse);
		
		System.out.println("DONE!");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;
		
		// find the instructor
		System.out.println("Finding Instructor with id : " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		// update the Instructor
		System.out.println("Updating the instructor with id : " + theId);
		
		tempInstructor.setEmail("adnan123@email.com");
		
		appDAO.update(tempInstructor);
		
		System.out.println("DONE!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 1;

		// find the instructor
		System.out.println("Finding Instructor with id : " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		
		System.out.println("tempInstructor : " + tempInstructor);
		System.out.println("The associated courses : " + tempInstructor.getCourses());
		
		System.out.println("DONE!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		
		// find the instructor
		System.out.println("Finding Instructor with id : " + theId);
		
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		
		System.out.println("tempInstructor : " + tempInstructor);
		
		// find courses for the instructor
		System.out.println("Find courses for instructor with id : " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		
		// associate the object with courses
		tempInstructor.setCourses(courses);
		
		System.out.println("The associated courses : " + tempInstructor.getCourses());

		System.out.println("DONE!");
	}

	private void findInstructorWithCourse(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding Instructor with id : " + theId);
		
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		
		System.out.println("tempInstructor : " + tempInstructor);
		
		System.out.println("The associated courses : " + tempInstructor.getCourses());
		
		System.out.println("DONE!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		
		// create the instructor
		Instructor tempInstructor = new Instructor("Adnan", "Khan", "adnan@gmail.com");
		
		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("YTadnan", "football");
		
		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		
		// create some courses
		Course tempCourse1 = new Course("Java Coding");
		Course tempCourse2 = new Course("Piano : in 10 Days");
		Course tempCourse3 = new Course("Football : panelty shooting");
		
		// add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		tempInstructor.add(tempCourse3);
		
		// saving the instructor
		
		// NOTE : This will also save the courses because of CascadeType.PERSIST
		
		System.out.println("Saving Instructor : " + tempInstructor);
		System.out.println("The Course : " + tempInstructor.getCourses());
		
		appDAO.save(tempInstructor);
		
		System.out.println("DONE!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Deleting the instructor with id : " + theId);
		
		appDAO.deleteInstructorDetailByID(theId);
		
		System.out.println("DONE!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		
		// get instructor detail object
		int theId = 2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		
		// print the instructor detail
		System.out.println("tempInstructorDetail : " + tempInstructorDetail);
		
		// print the associated instructor
		System.out.println("The associated instructor : " + tempInstructorDetail.getInstructor());
		System.out.println("DONE!");
	}

	private void deleteInstructor(AppDAO appDAO) {

		int theId = 1;

		System.out.println("Deleting the instructor with id : " + theId);

		appDAO.deleteInstructorByID(theId);

		System.out.println("DONE!");
	}

	private void findInstructor(AppDAO appDAO) {

		int theId = 1;

		System.out.println("Instructor with id : " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Your instructor is : " + tempInstructor);
		System.out.println("Associated instructorDetails only : " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

		// create the instructor
		Instructor tempInstructor = new Instructor("Adnan", "Khan", "adnan@gmail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("YTadnan", "football");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		// note : this will also save the details object because of CascadeType.ALL
		System.out.println(tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("DONE!");
	}

}
