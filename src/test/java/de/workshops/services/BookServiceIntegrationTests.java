package de.workshops.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.workshops.model.Book;
import de.workshops.model.Publisher;
import de.workshops.services.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceIntegrationTests {

	@Autowired
	private BookService bookService;
	
	@Test
	public void testCreateBook() {
		int initialSize = bookService.getBooks().size();
		
		Book book = createBook();
		
		assertTrue(initialSize < bookService.getBooks().size());
		assertEquals("The Pragmatic Programmer", book.getTitle());
		assertEquals("The Pragmatic Programmer", bookService.getBook(book.getId()).getTitle());
		
		bookService.deleteBook(book.getId());
	}
	
	@Test
	public void testUpdateBook() {
		Book book = bookService.getBook(0);
		book.setTitle("Test");
		
		Book updatedBook = bookService.updateBook(book);
		
		assertEquals("Test", book.getTitle());
		assertEquals("Test", bookService.getBook(0).getTitle());
		
		updatedBook.setTitle("Design Patterns");
		Book resetBook = bookService.updateBook(updatedBook);
		
		assertEquals("Design Patterns", resetBook.getTitle());
		assertEquals("Design Patterns", bookService.getBook(0).getTitle());
	}
	
	@Test
	public void testDeleteBook() {
		int initialSize = bookService.getBooks().size();
		
		Book book = createBook();
		
		assertTrue(initialSize < bookService.getBooks().size());
		
		bookService.deleteBook(book.getId());
		
		assertTrue(initialSize == bookService.getBooks().size());
	}
	
	private Book createBook() {
		Publisher addisonWesley = new Publisher();
		addisonWesley.setId(0);
		addisonWesley.setName("Addison-Wesley");
		addisonWesley.setUrl("http://www.addison-wesley.de/");
		Book pragmaticProgrammer = new Book();
		pragmaticProgrammer.setTitle("The Pragmatic Programmer");
		pragmaticProgrammer.setSubtitle("From Journeyman to Master");
		pragmaticProgrammer.setIsbn("978-0-20161-622-4");
		pragmaticProgrammer.setAbstractText("As a reviewer I got an early opportunity to read the book you are holding. It was great, even in draft form. Dave Thomas and Andy Hunt have something to say, and they know how to say it. I saw what they were doing and I knew it would work. I asked to write this foreword so that I could explain why.");
		pragmaticProgrammer.setNumPages(352);
		pragmaticProgrammer.setAuthor("Andrew Hunt, David Thomas");
		pragmaticProgrammer.setPublisher(addisonWesley);
		
		return bookService.createBook(pragmaticProgrammer);
	}
}
