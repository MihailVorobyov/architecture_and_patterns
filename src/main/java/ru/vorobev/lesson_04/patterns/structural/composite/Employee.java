package ru.vorobev.lesson_04.patterns.structural.composite;

import java.util.List;

public interface Employee {
	
	String getName();
	void setSalary(double salary);
	double getSalary();
	List<Role> getRoles();
}
