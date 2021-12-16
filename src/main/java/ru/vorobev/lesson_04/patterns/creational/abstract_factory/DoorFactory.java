package ru.vorobev.lesson_04.patterns.creational.abstract_factory;

public interface DoorFactory {
	
	public Door makeDoor();
	public DoorFittingExpert makeFittingExpert();
}
