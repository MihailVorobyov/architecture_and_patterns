package ru.vorobev.lesson_04.patterns.structural.decorator;

public class VanillaCoffee implements Coffee {
	
	private final Coffee coffee;
	
	public VanillaCoffee(Coffee coffee)
	{
		this.coffee = coffee;
	}
		
	@Override
	public double getCost() {
		
		return this.coffee.getCost() + 3;
	}
	
	@Override
	public String getDescription() {
		
		return this.coffee.getDescription() + ", vanilla";
	}
}
