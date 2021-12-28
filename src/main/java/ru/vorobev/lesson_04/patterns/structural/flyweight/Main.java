package ru.vorobev.lesson_04.patterns.structural.flyweight;

public class Main {
	
	public static void main(String[] args) {
		
		TeaMaker teaMaker = new TeaMaker();
		TeaShop shop = new TeaShop(teaMaker);
		
		shop.takeOrder("less sugar", 1);
		shop.takeOrder("more milk", 2);
		shop.takeOrder("without sugar", 5);
		
		shop.serve();
		// Serving tea to table# 1
		// Serving tea to table# 2
		// Serving tea to table# 5
	}
}
