package ru.vorobev.lesson_04.patterns.creational.singleton;

final class President {

	private static President instance;
	
	private President() {
	}
	
	public static President getInstance() {
		
		if (instance == null) {
			instance = new President();
		}
		return instance;
	}
}
