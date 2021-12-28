package ru.vorobev.lesson_04.patterns.behavioral.walker;

class Monkey implements Animal {
	public void shout() {
		System.out.println("Ooh oo aa aa!");
	}
	
	public void accept(AnimalOperation operation) {
		operation.visitMonkey(this);
	}
}
