package com.visilean.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.visilean.cruddemo.dao.StudentDAO;
import com.visilean.cruddemo.entity.Student;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> createStudent(studentDAO);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create a student object

		System.out.println("Creating new student");
		Student stuTemp = new Student("Adnan", "Khan", "adnankhan@gmail.com");

		// save the student object

		System.out.println("Saving the student");
		studentDAO.save(stuTemp);

		// display the id of saved student

		System.out.println("The id of the student which just got saved is : " + stuTemp.getId());
		
	}

}
