package com.springBoot.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
