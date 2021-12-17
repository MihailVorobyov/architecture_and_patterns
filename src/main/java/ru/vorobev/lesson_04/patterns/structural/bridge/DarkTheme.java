package ru.vorobev.lesson_04.patterns.structural.bridge;

/**
 * @author Mikhail Vorobev
 */

public class DarkTheme implements Theme {
	
	private final String color;
	
	public DarkTheme() {
		this.color = "Dark Black";
	}
	
	@Override
	public String getColor() {
		return color;
	}
}
