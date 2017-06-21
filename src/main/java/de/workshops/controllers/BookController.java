package de.workshops.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.workshops.messaging.Message;
import de.workshops.model.Book;
import de.workshops.model.ItemNotFoundException;
import de.workshops.model.Purchase;
import de.workshops.repositories.PurchaseRepository;
import de.workshops.services.BookService;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@Autowired
	private JmsTemplate jmsTemplate;

	@RequestMapping("/")
    public String start(Model model) {
		model.addAttribute("books", bookService.getBooks());
		
        return "books";
    }
	
	@RequestMapping("/book/{bookId}")
    public ModelAndView displayBook(@PathVariable int bookId, Model model) {
		Book book = bookService.getBook(bookId);
		if (book == null) {
			throw new ItemNotFoundException();
		}
		
		List<Purchase> purchases = purchaseRepository.findAllByBookId(bookId);
		
		model.addAttribute("book", book);
		model.addAttribute("purchases", purchases);
		
		jmsTemplate.convertAndSend("inbox", new Message("Book displayed: " + bookId));

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(book);
		modelAndView.addObject(purchases);

		return modelAndView;
    }
	
	@RequestMapping("/api/books")
	@ResponseBody
    public List<Book> getBooks() {
		return bookService.getBooks();
    }
	
	@RequestMapping("/api/book/{bookId}")
	@ResponseBody
    public Book getBook(@PathVariable int bookId) {
		Book book = bookService.getBook(bookId);
		if (book == null) {
			throw new ItemNotFoundException();
		}
		
		return book;
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
		throw new DataIntegrityViolationException("Not allowed at the moment.");
    }
}
