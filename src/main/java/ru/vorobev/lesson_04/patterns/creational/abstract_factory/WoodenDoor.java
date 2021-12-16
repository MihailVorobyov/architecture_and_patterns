package ru.vorobev.lesson_04.patterns.creational.abstract_factory;

public class WoodenDoor implements Door {
	
	@Override
	public String getDescription() {
		return "I am a wooden door";
	}
}
