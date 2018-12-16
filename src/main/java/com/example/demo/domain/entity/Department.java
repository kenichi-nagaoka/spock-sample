package com.example.demo.domain.entity;

public class Department {
	
	private final String id;
	
	private final String name;
	
	public Department(final String id, final String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}
