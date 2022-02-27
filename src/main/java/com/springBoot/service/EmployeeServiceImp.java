package com.springBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springBoot.Dao.EmployeeDao;
import com.springBoot.Dao.EmployeeRepository;
import com.springBoot.entity.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	EmployeeServiceImp(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override

	public List<Employee> getEmployeeList() {
		return employeeRepository.findAll();
	}

	@Override

	public Employee getEmployeeById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);

		Employee employee = null;
		if (result.isPresent()) {
			employee = result.get();

		} else {
			throw new RuntimeException();
		}

		return employee;
	}

	@Override

	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override

	public void deleteEmployee(int id) {
		employeeRepository.delete(getEmployeeById(id));

	}

}
