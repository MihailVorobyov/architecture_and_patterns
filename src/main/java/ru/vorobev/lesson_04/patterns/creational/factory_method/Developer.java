package ru.vorobev.lesson_04.patterns.creational.factory_method;

/**
 * @author Mikhail Vorobev
 */

public class Developer implements Interviewer{
	
	@Override
	public void askQuestions() {
		System.out.println("Asking about design patterns!");
	}
}
