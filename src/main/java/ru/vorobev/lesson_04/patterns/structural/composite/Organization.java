package ru.vorobev.lesson_04.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Organization {
	
	private List<Employee> employees;
	
	public Organization() {
		this.employees = new ArrayList<>();
	}
	
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	
	public double getNetSalaries() {
		return employees.stream().mapToDouble(Employee::getSalary).sum();
	}
}
