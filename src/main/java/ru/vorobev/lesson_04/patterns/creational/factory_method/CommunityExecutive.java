package ru.vorobev.lesson_04.patterns.creational.factory_method;

/**
 * @author Mikhail Vorobev
 */

public class CommunityExecutive implements Interviewer{
	
	@Override
	public void askQuestions() {
		System.out.println("Asking about community building");
	}
}
