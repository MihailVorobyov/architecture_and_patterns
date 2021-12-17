package ru.vorobev.lesson_04.patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

// Acts as a factory and saves the tea
class TeaMaker
{
	private final Map<String, KarakTea> availableTea = new HashMap();
	
	public KarakTea make(String preference)
	{
		if (!availableTea.containsKey(preference)) {
			this.availableTea.put(preference, new KarakTea());
		}
		
		return this.availableTea.get(preference);
	}
}
