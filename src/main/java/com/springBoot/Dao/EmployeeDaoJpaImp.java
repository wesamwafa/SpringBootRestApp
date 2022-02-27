package com.springBoot.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springBoot.entity.Employee;

@Repository
public class EmployeeDaoJpaImp implements EmployeeDao {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDaoJpaImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> getEmployeeList() {

		Query theQuery = entityManager.createQuery("from Employee");
		List<Employee> employeeList = theQuery.getResultList();
		return employeeList;
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub

	}

}
