package com.springBoot.Dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springBoot.entity.Employee;

@Repository
public class EmployeeDAOHibernateImp implements EmployeeDao {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOHibernateImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> getEmployeeList() {
		Session session = entityManager.unwrap(Session.class);
		List<Employee> employeeList = session.createQuery("from Employee", Employee.class).getResultList();
		return employeeList;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Session session = entityManager.unwrap(Session.class);

		Employee employee = session.get(Employee.class, id);

		return employee;
	}

	@Override
	public void addEmployee(Employee employee) {
		Session session = entityManager.unwrap(Session.class);

		session.saveOrUpdate(employee);

	}

	@Override
	public void deleteEmployee(int id) {

		Session session = entityManager.unwrap(Session.class);

		session.delete(session.get(Employee.class, id));

	}

}
