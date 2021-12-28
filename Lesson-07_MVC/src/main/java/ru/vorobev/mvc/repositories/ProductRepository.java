package ru.vorobev.mvc.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.vorobev.mvc.entities.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
	
	private List<Product> productList;
	
	@Autowired
	public ProductRepository() {
		productList = new ArrayList<>();
		productList.add(new Product(1L, "Notebook", "Very good notebook", 199.99));
		productList.add(new Product(2L, "Mouse", "Very good mouse", 25.00));
		productList.add(new Product(3L, "Keyboard", "Not for notebook...", 30.00));
	}
	
	public List<Product> findAllProducts() {
		return productList;
	}
	
	public Product findOneById(long id) {
		return productList.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
	}
}
