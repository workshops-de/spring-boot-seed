package de.workshops.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping("/api/books")
	@ResponseBody
    public List<Book> getBooks() {
		return bookService.getBooks();
    }
	
	@RequestMapping("/api/book/{bookId}")
	@ResponseBody
    public Book getBook(@PathVariable int bookId) {
		return bookService.getBook(bookId);
    }
	
	@RequestMapping(
			value = "/api/book",
			method = RequestMethod.POST
	)
	@ResponseBody
    public Book createBook(@RequestBody Book book) {
		return bookService.createBook(book);
    }
	
	@RequestMapping(
			value = "/api/book",
			method = RequestMethod.PUT
	)
	@ResponseBody
    public Book updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
    }
	
	@RequestMapping(
			value = "/api/book/{bookId}",
			method = RequestMethod.DELETE
	)
	@ResponseBody
    public String deleteBook(@PathVariable int bookId) {
		return "OK";
    }
}
