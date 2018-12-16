package com.example.demo.domain.entity;

public class Employee {

	private final String id;
	
	private final String name;

	private final Department department;
	

	public Employee(final String id, final String name, final Department department) {
		this.id = id;
		this.name = name;
		this.department = department;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Department getDepartment() {
		return department;
	}
}
