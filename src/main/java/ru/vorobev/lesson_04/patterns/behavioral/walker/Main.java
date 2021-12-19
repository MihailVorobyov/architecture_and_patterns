package ru.vorobev.lesson_04.patterns.behavioral.walker;

public class Main
{
	public static void main(String[] args) {
		
		Animal monkey = new Monkey();
		Animal lion = new Lion();
		Animal dolphin = new Dolphin();
		
		AnimalOperation speak = new Speak();
		AnimalOperation jump = new Jump();
		
		monkey.accept(speak);   // Ooh oo aa aa!
		monkey.accept(jump);    // Jumped 20 feet high! on to the tree!
		
		lion.accept(speak);     // Roaaar!
		lion.accept(jump);      // Jumped 7 feet! Back on the ground!
		
		dolphin.accept(speak);  // Tuut tutt tuutt!
		dolphin.accept(jump);   // Walked on water a little and disappeared
	}
}

