package com.javaspring.emsbackend.service;

import java.util.List;

import com.javaspring.emsbackend.dto.EmployeeDto;


public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeId(Long employeeId);
	
	List<EmployeeDto> getAllEmployees();
	
	EmployeeDto updateEmployee(Long employeeId,EmployeeDto updatedEmployee);

	void DeleteEmployee(Long employeeId);
}
