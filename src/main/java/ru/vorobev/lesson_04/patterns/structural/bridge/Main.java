package ru.vorobev.lesson_04.patterns.structural.bridge;

/**
 * @author Mikhail Vorobev
 */

public class Main {
	
	public static void main(String[] args) {
		
		Theme darkTheme = new DarkTheme();
		
		About about = new About(darkTheme);
		Careers careers= new Careers(darkTheme);
		
		System.out.println(about.getContent());
		System.out.println(careers.getContent());
	}
}
