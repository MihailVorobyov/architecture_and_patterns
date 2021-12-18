package ru.vorobev.lesson_04.patterns.behavioral.observer;

public class JobPost {
	
	private final String title;
	
	public JobPost(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
}
