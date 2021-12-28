package ru.vorobev.lesson_04.patterns.behavioral.command;

public class Bulb {
	
	public void turnOn() {
		System.out.println("Bulb has been lit");
	}
	
	public void turnOff() {
		System.out.println("Darkness!");
	}
}
