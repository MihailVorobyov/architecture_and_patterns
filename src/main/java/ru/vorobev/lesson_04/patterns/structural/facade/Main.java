package ru.vorobev.lesson_04.patterns.structural.facade;

public class Main {
	
	public static void main(String[] args) {
		
		ComputerFacade computer = new ComputerFacade(new Computer());
		computer.turnOn(); // Ouch! Beep beep! Loading.. Ready to be used!
		computer.turnOff(); // Bup bup buzzz! Haah! Zzzzz
	}
}
