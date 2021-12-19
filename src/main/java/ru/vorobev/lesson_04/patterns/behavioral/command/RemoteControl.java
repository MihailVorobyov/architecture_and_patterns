package ru.vorobev.lesson_04.patterns.behavioral.command;

public class RemoteControl {

	public void submit(Command command) {
		command.execute();
	}
}
