package com.javaspring.emsbackend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.javaspring.emsbackend.Mapper.EmployeeMapper;
import com.javaspring.emsbackend.dto.EmployeeDto;
import com.javaspring.emsbackend.entity.Employee;
import com.javaspring.emsbackend.exception.ResourceNotFoundException;
import com.javaspring.emsbackend.repository.EmployeeRepository;
import com.javaspring.emsbackend.service.EmployeeService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

	 
	 private EmployeeRepository employeeRepository;
     public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
	        this.employeeRepository = employeeRepository;
	    }
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
		
	}
	@Override
	public EmployeeDto getEmployeeId(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
		        .orElseThrow(() ->
		               new ResourceNotFoundException("Employee is not exists with given id : "+ employeeId));
		        
		return EmployeeMapper.mapToEmployeeDto(employee);
	}
	
	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		
		return employees.stream().map((employee) -> 
		                  EmployeeMapper.mapToEmployeeDto(employee))
				         .collect(Collectors.toList());
	}
	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
	Employee employee =	employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not exist with given id: " + employeeId));
	    employee.setFirstName(updatedEmployee.getFirstName());
	    employee.setLastName(updatedEmployee.getLastName());
	    employee.setEmail(updatedEmployee.getEmail());
	    
	    Employee updatedEmployeeobj =  employeeRepository.save(employee);
		
	    return EmployeeMapper.mapToEmployeeDto(updatedEmployeeobj);
	}
	
	
	@Override
	public void DeleteEmployee(Long employeeId) {
	 Employee employee =	employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not exist with given id: " + employeeId));
		
		employeeRepository.deleteById(employeeId);
		
	}
	
	
	
	
	
}

   

