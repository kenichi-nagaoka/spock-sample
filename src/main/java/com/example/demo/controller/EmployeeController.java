package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.entity.Employee;
import com.example.demo.domain.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/employees")
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> employeeList = employeeService.getEmployees();
		if (CollectionUtils.isEmpty(employeeList)) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);	
		}
		return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
	}
}
