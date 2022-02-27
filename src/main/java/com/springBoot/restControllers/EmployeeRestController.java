package com.springBoot.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.entity.Employee;
import com.springBoot.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping("/employees")
	public List<Employee> getEmployeesList() {

		return employeeService.getEmployeeList();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getOneEmployee(@PathVariable int employeeId) {

		Employee employee = employeeService.getEmployeeById(employeeId);
		System.out.println(employee.toString());

		if (employee == null) {
			throw new RuntimeException("Employee Not Found");
		}

		return employee;

	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {

		employee.setId(0);
		employeeService.addEmployee(employee);
		return employee;

	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {

		employeeService.addEmployee(employee);
		return employee;
	}

	@DeleteMapping("/employees/{employeeId}")
	public void deleteEmployee(@PathVariable int employeeId) {

		Employee employee = employeeService.getEmployeeById(employeeId);

		if (employee == null) {
			throw new RuntimeException("");
		}
		employeeService.deleteEmployee(employeeId);
	}

}
