package ru.vorobev.lesson_04.patterns.behavioral.command;

public interface Command {
	
	void execute();
	void undo();
	void redo();
}
