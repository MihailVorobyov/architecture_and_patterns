package ru.vorobev.lesson_04.patterns.structural.bridge;

/**
 * @author Mikhail Vorobev
 */

public class About implements WebPage {
	
	protected Theme theme;
	
	public About(Theme theme)
	{
		this.theme = theme;
	}
	
	public String getContent()
	{
		return "About page in " + theme.getColor();
	}
}
