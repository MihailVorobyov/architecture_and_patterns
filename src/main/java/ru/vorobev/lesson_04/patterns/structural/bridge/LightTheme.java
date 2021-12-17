package ru.vorobev.lesson_04.patterns.structural.bridge;

/**
 * @author Mikhail Vorobev
 */

public class LightTheme implements Theme {
	
	private final String color;
	
	public LightTheme() {
		this.color = "Off white";
	}
	
	@Override
	public String getColor() {
		return color;
	}
}
