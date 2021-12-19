package ru.vorobev.lesson_04.patterns.creational.prototype;

public class Main {
	
	public static void main(String[] args) {
		
		Sheep original = new Sheep("Jolly");
		System.out.println(original.getName()); // Jolly
		System.out.println(original.getCategory()); // Mountain Sheep

		// Clone and modify what is required
		Sheep cloned = original.clone();
		cloned.setName("Dolly");
		System.out.println(cloned.getName()); // Dolly
		System.out.println(cloned.getCategory()); // Mountain sheep
	}
}
