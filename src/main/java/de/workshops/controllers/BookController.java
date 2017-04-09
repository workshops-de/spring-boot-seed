package de.workshops.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.workshops.model.Book;
import de.workshops.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;

	@RequestMapping("/")
    public String start(Model model) {
		model.addAttribute("books", bookService.getBooks());
		
        return "books";
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/books")
	@ResponseBody
    public List<Book> books(Model model) {
		return bookService.getBooks();
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/book/{bookId}")
	@ResponseBody
    public Book book(@PathVariable int bookId, Model model) {
		return bookService.getBook(bookId);
    }
}
