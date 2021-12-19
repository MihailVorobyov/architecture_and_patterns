package ru.vorobev.lesson_04.patterns.behavioral.observer;

public class Main {
	
	public static void main(String[] args) {
		// Create subscribers
		JobSeeker johnDoe = new JobSeeker("John Doe");
		JobSeeker janeDoe = new JobSeeker("Jane Doe");

		// Create publisher and attach subscribers
		EmploymentAgency jobPostings = new EmploymentAgency();
		jobPostings.addJobSeeker(johnDoe);
		jobPostings.addJobSeeker(janeDoe);

		// Add a new job and see if subscribers get notified
		jobPostings.publicJobPost(new JobPost("Software Engineer"));

		// Output
		// Hi John Doe! New job posted: Software Engineer
		// Hi Jane Doe! New job posted: Software Engineer
	}
}
