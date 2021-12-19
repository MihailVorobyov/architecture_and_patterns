package ru.vorobev.lesson_04.patterns.creational.singleton;

public class Main {
	
	public static void main(String[] args) {
		
		President president1 = President.getInstance();
		President president2 = President.getInstance();
		
		System.out.println(president1 == president2); // true
		System.out.println(president1.equals(president2)); // true
		
	}
}
