package ru.vorobev.lesson_04.patterns.behavioral.command;

public class Main {
	
	public static void main(String[] args) {
		Bulb bulb = new Bulb();
		
		Command turnOn = new TurnOn(bulb);
		Command turnOff = new TurnOff(bulb);
		
		RemoteControl remote = new RemoteControl();
		remote.submit(turnOn); // Bulb has been lit!
		remote.submit(turnOff); // Darkness!
	}
}
