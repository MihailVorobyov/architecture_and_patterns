package ru.vorobev.lesson_04.patterns.behavioral.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class JobSeeker implements PropertyChangeListener {
	
	private  String name;
	
	public JobSeeker(String name) {
		this.name = name;
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// Do something with the job posting
		JobPost job = (JobPost) evt.getNewValue();
		System.out.println("Hi "+ name + "! New job posted: " + job.getTitle());
	}
}
