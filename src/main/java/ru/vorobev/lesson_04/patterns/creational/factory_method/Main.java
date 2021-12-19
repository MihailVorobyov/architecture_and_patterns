package ru.vorobev.lesson_04.patterns.creational.factory_method;

/**
 * @author Mikhail Vorobev
 */

public class Main {
	
	public static void main(String[] args) {
		
		HiringManager devManager = new DevelopmentManager();
		devManager.takeInterview(); // Output: Asking about design patterns
		
		HiringManager marketingManager = new MarketingManager();
		marketingManager.takeInterview(); // Output: Asking about community building.
	}
}
