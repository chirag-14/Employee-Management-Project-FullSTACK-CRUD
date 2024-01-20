package com.javaspring.emsbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaspring.emsbackend.dto.EmployeeDto;
import com.javaspring.emsbackend.service.EmployeeService;

import lombok.AllArgsConstructor;


@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public  class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
     public EmployeeController() {
		super();
	}
     
     public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
     
     public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	//Build Add Employee REST API
	@PostMapping
	public ResponseEntity<EmployeeDto>createEmployee(@RequestBody  EmployeeDto employeeDto){
	EmployeeDto savedEmployee =	employeeService.createEmployee(employeeDto);
	return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
	}
	
	//Build Get Employee REST API
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
	EmployeeDto employeeDto1 = employeeService.getEmployeeId(employeeId);
		return ResponseEntity.ok(employeeDto1);
	}
	
	//Build Get All Employees Rest API
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	}
	
	//Build UpdateEmployee RestApi
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto>updatedEmployee(@PathVariable("id") Long employeeId,
			                                          @RequestBody EmployeeDto updatedEmployee){
		EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);
		return ResponseEntity.ok(employeeDto);
		
	}
	
	//Build Delete Employee Rest API
	  @DeleteMapping("{id}")
	   public  ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
		   employeeService.DeleteEmployee(employeeId);
		   return ResponseEntity.ok("Employee deleted Successfully!.");
	   }
	}
  

