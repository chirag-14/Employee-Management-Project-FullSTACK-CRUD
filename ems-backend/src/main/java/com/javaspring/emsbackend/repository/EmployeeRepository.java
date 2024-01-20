package com.javaspring.emsbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaspring.emsbackend.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
}
