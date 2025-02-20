package com.visilean.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.visilean.demo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	@GetMapping("/studentList")
	public List<Student> getStudent() {

		List<Student> stuList = new ArrayList<Student>();
		stuList.add(new Student("Adnan", "Khan"));
		stuList.add(new Student("Abhay", "Rajawat"));
		stuList.add(new Student("Hasrh", "Tomar"));

		return stuList;

	}

	@GetMapping("/student/{studentId}")
	public Student getStudentById(@PathVariable int studentId) {

		List<Student> stuList = new ArrayList<Student>();

		stuList.add(new Student("Adnan", "Khan"));
		stuList.add(new Student("Abhay", "Rajawat"));
		stuList.add(new Student("Harsh", "Tomar"));

		return stuList.get(studentId);

	}

}
