package ru.vorobev.lesson_04.patterns.structural.bridge;

/**
 * @author Mikhail Vorobev
 */

public class AquaTheme implements Theme {
	
	private final String color;
	
	public AquaTheme() {
		this.color = "Light blue";
	}
	
	@Override
	public String getColor() {
		return color;
	}
}
