package ru.vorobev.mvc.services;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class PageService {
	
	public Map<String,String> getPages() {
		Map<String,String> pages = new LinkedHashMap<>();
		pages.put("/products", "Product list");
		pages.put("/contacts", "Contact us");
		pages.put("/about", "About us");
		
		return pages;
	}
}
