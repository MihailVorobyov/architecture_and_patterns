package ru.vorobev.lesson_04.patterns.creational.factory_method;

/**
 * @author Mikhail Vorobev
 */

public abstract class HiringManager {
	
	// Factory method
	protected abstract Interviewer makeInterviewer();
	
	public void takeInterview()
	{
		Interviewer interviewer = this.makeInterviewer();
		interviewer.askQuestions();
	}
}
