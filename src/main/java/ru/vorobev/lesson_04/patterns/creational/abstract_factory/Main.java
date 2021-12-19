package ru.vorobev.lesson_04.patterns.creational.abstract_factory;

public class Main {
	
	public static void main(String[] args) {
		
		
		DoorFactory woodenFactory = new WoodenDoorFactory();
		
		Door woodenDoor = woodenFactory.makeDoor();
		DoorFittingExpert carpenter = woodenFactory.makeFittingExpert();
		
		System.out.println(woodenDoor.getDescription());  // Output: I am a wooden door
		System.out.println(carpenter.getDescription()); // Output: I can only fit wooden doors

		// Same for Iron Factory
		DoorFactory ironFactory = new IronDoorFactory();
		
		Door ironDoor = ironFactory.makeDoor();
		DoorFittingExpert welder = ironFactory.makeFittingExpert();
		
		System.out.println(ironDoor.getDescription());  // Output: I am an iron door
		System.out.println(welder.getDescription()); // Output: I can only fit iron doors
	}
	
}
