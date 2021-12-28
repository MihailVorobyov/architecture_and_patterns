package ru.vorobev.lesson_04.patterns.creational.simple_factory;

/**
 * @author Mikhail Vorobev
 */

public class DoorFactory {
	
	public static Door makeDoor(float width, float height) {
		return new WoodenDoor(width, height);
	}
}
