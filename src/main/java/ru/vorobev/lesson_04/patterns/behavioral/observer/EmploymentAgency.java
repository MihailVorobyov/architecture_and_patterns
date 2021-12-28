package ru.vorobev.lesson_04.patterns.behavioral.observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EmploymentAgency {
	
	private JobPost jobPost;
	private final PropertyChangeSupport psc;
	
	public EmploymentAgency() {
		this.psc = new PropertyChangeSupport(this);
	}
	
	public void addJobSeeker(PropertyChangeListener pcl) {
		psc.addPropertyChangeListener(pcl);
	}
	
	public void removeJobSeeker(PropertyChangeListener pcl) {
		psc.removePropertyChangeListener(pcl);
	}
	
	public void publicJobPost(JobPost jobPost) {
		psc.firePropertyChange("jobPost", this.jobPost, jobPost);
		this.jobPost = jobPost;
	}
}
