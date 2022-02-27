package com.springBoot.Dao;

import java.util.List;

import com.springBoot.entity.Employee;

public interface EmployeeDao {
	
	public List<Employee> getEmployeeList();
	
	public Employee getEmployeeById(int id);
	
	
	public void addEmployee(Employee employee);
	
	public void deleteEmployee(int id);
	
	
	
	

}
