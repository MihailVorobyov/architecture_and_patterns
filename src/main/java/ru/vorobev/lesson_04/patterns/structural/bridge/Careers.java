package ru.vorobev.lesson_04.patterns.structural.bridge;

/**
 * @author Mikhail Vorobev
 */

public class Careers {
	
	protected Theme theme;
	
	public Careers(Theme theme)
	{
		this.theme = theme;
	}
	
	public String getContent()
	{
		return "Careers page in " + theme.getColor();
	}
}
