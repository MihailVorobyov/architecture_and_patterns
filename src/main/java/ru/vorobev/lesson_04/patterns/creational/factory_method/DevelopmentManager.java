package ru.vorobev.lesson_04.patterns.creational.factory_method;

/**
 * @author Mikhail Vorobev
 */

public class DevelopmentManager extends HiringManager {
	
	@Override
	protected Interviewer makeInterviewer() {
		return new Developer();
	}
}
