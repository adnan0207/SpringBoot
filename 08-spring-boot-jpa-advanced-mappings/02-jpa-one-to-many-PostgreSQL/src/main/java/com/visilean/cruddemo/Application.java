package com.visilean.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.visilean.cruddemo.dao.AppDAO;
import com.visilean.cruddemo.entity.Course;
import com.visilean.cruddemo.entity.Instructor;
import com.visilean.cruddemo.entity.InstructorDetail;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
//			findInstructorDetail(appDAO);
//			deleteInstructorDetail(appDAO);
			createInstructorWithCourses(appDAO);
		};
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
