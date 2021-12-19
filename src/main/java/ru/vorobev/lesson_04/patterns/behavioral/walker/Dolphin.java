package ru.vorobev.lesson_04.patterns.behavioral.walker;

class Dolphin implements Animal {
	public void speak() {
		System.out.println("Tuut tuttu tuutt!");
	}
	
	public void accept(AnimalOperation operation) {
		operation.visitDolphin(this);
	}
}
