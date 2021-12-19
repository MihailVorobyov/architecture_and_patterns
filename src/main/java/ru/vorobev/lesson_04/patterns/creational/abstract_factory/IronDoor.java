package ru.vorobev.lesson_04.patterns.creational.abstract_factory;

public class IronDoor implements Door {
	
	@Override
	public String getDescription() {
		return "I am a iron door";
	}
}
