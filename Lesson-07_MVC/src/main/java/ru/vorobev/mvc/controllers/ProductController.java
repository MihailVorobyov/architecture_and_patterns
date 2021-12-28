package ru.vorobev.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vorobev.mvc.services.PageService;
import ru.vorobev.mvc.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private PageService pageService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public String getProductsPage(Model model) {
		model.addAttribute("pages", pageService.getPages());
		model.addAttribute("productList", productService.getAllProducts());
		return "products";
	}
	
	@GetMapping("/{id}")
	public String getProductPage(Model model,
	                              @PathVariable("id") long productId) {
		model.addAttribute("pages", pageService.getPages());
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}
	
}
