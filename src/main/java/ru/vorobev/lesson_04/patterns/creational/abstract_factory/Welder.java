package ru.vorobev.lesson_04.patterns.creational.abstract_factory;

public class Welder implements DoorFittingExpert {
	
	@Override
	public String getDescription() {
		return "I can only fit iron doors";
	}
}
