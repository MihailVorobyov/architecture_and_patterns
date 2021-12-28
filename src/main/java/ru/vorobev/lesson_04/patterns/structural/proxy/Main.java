package ru.vorobev.lesson_04.patterns.structural.proxy;

public class Main {
	
	public static void main(String[] args) {
		Door door = new LabDoor();
		SecuredDoor securedDoor = new SecuredDoor(door);
		securedDoor.open("invalid"); // Big no! It ain't possible.
		
		securedDoor.open("$ecr@t"); // Opening lab door
		securedDoor.close(); // Closing lab door
	}
}
