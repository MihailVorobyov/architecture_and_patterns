package ru.vorobev.lesson_04.patterns.creational.builder;
public class Main {
	
	public static void main(String[] args) {
		Burger burger = new BurgerBuilder(30)
			.addPepperoni()
			.addLettuce()
			.addTomato()
			.build();
	}
}
