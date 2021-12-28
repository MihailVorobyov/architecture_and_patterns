package ru.vorobev.lesson_04.patterns.structural.composite;

public class Main {
	
	public static void main(String[] args) {
		
		// Prepare the employees
		Employee john = new Developer("John Doe", 12000);
		Employee jane = new Designer("Jane Doe", 15000);

		// Add them to organization
		Organization organization = new Organization();
		organization.addEmployee(john);
		organization.addEmployee(jane);
		
		System.out.println("Net salaries: " + organization.getNetSalaries()); // Net Salaries: 27000.0
	}
}
