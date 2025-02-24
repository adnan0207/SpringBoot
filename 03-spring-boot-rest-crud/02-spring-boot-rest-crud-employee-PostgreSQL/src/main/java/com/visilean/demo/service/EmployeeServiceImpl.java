package com.visilean.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.visilean.demo.dao.EmployeeRepository;
import com.visilean.demo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository emplpyeeRepository;

	public EmployeeServiceImpl(EmployeeRepository emplpyeeRepository) {
		this.emplpyeeRepository = emplpyeeRepository;
	}

	public List<Employee> findAll() {
		return emplpyeeRepository.findAll();
	}

	public Employee findById(int theID) {
		Optional<Employee> empById = emplpyeeRepository.findById(theID);

		Employee toPrintEmp = null;

		if (empById.isPresent()) {
			toPrintEmp = empById.get();
		} else {
			throw new RuntimeException("Did not find employee id : " + theID);
		}

		return toPrintEmp;
	}

	// we have removed @Transactional because JpaRepository take care if this automatically
	public Employee save(Employee emp) {
		return emplpyeeRepository.save(emp);
	}

	// we have removed @Transactional because JpaRepository take care if this automatically
	public void delete(int theID) {
		emplpyeeRepository.deleteById(theID);
	}
}
