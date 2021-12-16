package ru.vorobev.lesson_04.patterns.creational.prototype;

public class Sheep {
	private String name;
	private String category;
	
	public Sheep(String name) {
		this.name = name;
		this.category = "Mountain Sheep";
	}
	
	private Sheep(Sheep sheep) {
		this.name = sheep.getName();
		this.category = sheep.getCategory();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCategory() {
		return category;
	}
	
	public Sheep clone() {
		return new Sheep(this);
	}
}
