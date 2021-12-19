package ru.vorobev.lesson_04.patterns.structural.proxy;

public class SecuredDoor {
	
	private final Door door;
	
	public SecuredDoor(Door door) {
		this.door = door;
	}
	
	public void open(String password) {
		if (this.authenticate(password)) {
			this.door.open();
		} else {
			System.out.println("Big no! It ain't possible.");
		}
	}
	
	public boolean authenticate(String password) {
		return "$ecr@t".equals(password);
	}
	
	public void close() {
		this.door.close();
	}
}
