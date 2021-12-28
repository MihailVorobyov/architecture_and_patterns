package ru.vorobev.mvc.entities;

import lombok.Data;

@Data
public class Product {
	
	private long id;
	private String title;
	private String description;
	private double price;
	
	public Product(long id, String title, String description, double price) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
	}
	
	public Product() {
	}
}
