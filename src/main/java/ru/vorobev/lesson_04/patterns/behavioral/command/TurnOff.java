package ru.vorobev.lesson_04.patterns.behavioral.command;

public class TurnOff implements Command {
	
	private Bulb bulb;
	
	public TurnOff(Bulb bulb) {
		this.bulb = bulb;
	}
	
	@Override
	public void execute() {
		bulb.turnOff();
	}
	
	@Override
	public void undo() {
		bulb.turnOn();
	}
	
	@Override
	public void redo() {
		execute();
	}
}
