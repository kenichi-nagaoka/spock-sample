package com.example.demo.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Department;
import com.example.demo.domain.entity.Employee;

@Service
public class EmployeeService {

	public List<Employee> getEmployees() {
		Department department = new Department("001", "部署A");
		return new ArrayList<Employee>() {
			{
				this.add(new Employee("00000001", "社員A", department));
				this.add(new Employee("00000002", "社員B", department));
			}
		};
	}

}
