package ru.vorobev.lesson_04.patterns.structural.flyweight;

import java.util.*;

public class TeaShop {
	
	private Map<Integer, KarakTea> orders;
	private TeaMaker teaMaker;
	
	public TeaShop(TeaMaker teaMaker) {
		this.teaMaker = teaMaker;
		this.orders = new HashMap<>();
	}
	
	public void takeOrder(String teaType, int table) {
		this.orders.put(table, teaMaker.make(teaType));
	}
	
	public void serve() {
		orders.forEach((k, v) -> System.out.println("Serving tea to table# " + k));
	}
}
