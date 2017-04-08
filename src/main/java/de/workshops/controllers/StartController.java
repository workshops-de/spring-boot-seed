package de.workshops.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import de.workshops.services.BookService;

@Controller
public class StartController {
	
	@Autowired
	private BookService bookService;

	@RequestMapping("/")
    public String start(Model model) {
		model.addAttribute("books", bookService.getBooks());
		
        return "start";
    }
}
