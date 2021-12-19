package ru.vorobev.lesson_04.patterns.structural.composite;

import java.util.List;

public class Designer implements Employee {
	
	private String name;
	private double salary;
	private List<Role> roles;
	
	public Designer(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public double getSalary() {
		return salary;
	}
	
	@Override
	public List<Role> getRoles() {
		return roles;
	}
}
