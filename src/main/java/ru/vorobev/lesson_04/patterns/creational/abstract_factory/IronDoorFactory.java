package ru.vorobev.lesson_04.patterns.creational.abstract_factory;

public class IronDoorFactory implements DoorFactory {
	
	@Override
	public Door makeDoor() {
		return new IronDoor();
	}
	
	@Override
	public DoorFittingExpert makeFittingExpert() {
		return new Welder();
	}
}
