package ru.vorobev.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vorobev.mvc.entities.Product;
import ru.vorobev.mvc.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts() {
		return productRepository.findAllProducts();
	}
	
	public Product getProductById(long id) {
		return productRepository.findOneById(id);
	}
}
