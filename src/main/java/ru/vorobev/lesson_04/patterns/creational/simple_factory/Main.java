package ru.vorobev.lesson_04.patterns.creational.simple_factory;

/**
 * @author Mikhail Vorobev
 */

public class Main {
	public static void main(String[] args) {
		
		// Make me a door of 100x200
		Door door1 = DoorFactory.makeDoor(100, 200);
		
		System.out.println("Wigth: " + door1.getWidth());
		System.out.println("Height: " + door1.getHeight());
		
		// Make me a door of 50x100
		Door door2 = DoorFactory.makeDoor(50, 100);
	}
}
