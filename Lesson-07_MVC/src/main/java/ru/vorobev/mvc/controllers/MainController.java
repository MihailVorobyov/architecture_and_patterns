package ru.vorobev.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.vorobev.mvc.services.PageService;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private PageService pageService;
	
	@GetMapping("")
	public String getIndexPage(Model model) {
		model.addAttribute("pages", pageService.getPages());
		return "index";
	}
	
	@GetMapping("about")
	public String getAboutPage(Model model) {
		model.addAttribute("pages", pageService.getPages());
		return "about";
	}
	
	@GetMapping("contacts")
	public String getContactsPage(Model model) {
		model.addAttribute("pages", pageService.getPages());
		return "contacts";
	}
	
}
