package de.workshops.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.workshops.model.Book;
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
	
	@RequestMapping("/books")
	@ResponseBody
    public List<Book> books(Model model) {
		return bookService.getBooks();
    }
}
