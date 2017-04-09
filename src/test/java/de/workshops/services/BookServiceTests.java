package de.workshops.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.workshops.model.Book;
import de.workshops.model.Publisher;
import de.workshops.services.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTests {

	@Mock
	private BookService bookService;
    
    @Before
    public void setup() {
    	List<Book> books = new ArrayList<>();
		
		Publisher addisonWesley = new Publisher();
		addisonWesley.setName("Addison-Wesley");
		addisonWesley.setUrl("http://www.addison-wesley.de/");
		Publisher dpunkt = new Publisher();
		dpunkt.setName("dpunkt.verlag");
		dpunkt.setUrl("http://dpunkt.de/");
		Publisher noStarchPress = new Publisher();
		noStarchPress.setName("No Starch Press");
		noStarchPress.setUrl("https://www.nostarch.com/");
		
		Book designPatterns = new Book();
		designPatterns.setTitle("Design Patterns");
		designPatterns.setSubtitle("Elements of Reusable Object-Oriented Software");
		designPatterns.setIsbn("978-0-20163-361-0");
		designPatterns.setAbstractText("Capturing a wealth of experience about the design of object-oriented software, four top-notch designers present a catalog of simple and succinct solutions to commonly occurring design problems. Previously undocumented, these 23 patterns allow designers to create more flexible, elegant, and ultimately reusable designs without having to rediscover the design solutions themselves.");
		designPatterns.setNumPages(395);
		designPatterns.setAuthor("Erich Gamma / Richard Helm / Ralph E. Johnson / John Vlissides");
		designPatterns.setPublisher(addisonWesley);
		books.add(designPatterns);
		Book rest = new Book();
		rest.setTitle("REST und HTTP");
		rest.setSubtitle("Entwicklung und Integration nach dem Architekturstil des Web");
		rest.setIsbn("978-3-86490-120-1");
		rest.setAbstractText("Das Buch bietet eine theoretisch fundierte, vor allem aber praxistaugliche Anleitung zum professionellen Einsatz von RESTful HTTP. Es beschreibt den Architekturstil REST (Representational State Transfer) und seine Umsetzung im Rahmen der Protokolle des World Wide Web (HTTP, URIs und andere).");
		rest.setNumPages(330);
		rest.setAuthor("Stefan Tilkov / Martin Eigenbrodt / Silvia Schreier / Oliver Wolf");
		rest.setPublisher(dpunkt);
		books.add(rest);
		Book eloquentJavaScript = new Book();
		eloquentJavaScript.setTitle("Eloquent JavaScript");
		eloquentJavaScript.setSubtitle("A Modern Introduction to Programming");
		eloquentJavaScript.setIsbn("978-1-59327-584-6");
		eloquentJavaScript.setAbstractText("JavaScript lies at the heart of almost every modern web application, from social apps to the newest browser-based games. Though simple for beginners to pick up and play with, JavaScript is a flexible, complex language that you can use to build full-scale applications.");
		eloquentJavaScript.setNumPages(472);
		eloquentJavaScript.setAuthor("Marijn Haverbeke");
		eloquentJavaScript.setPublisher(noStarchPress);
		books.add(eloquentJavaScript);
		
    	when(bookService.getBooks()).thenReturn(books);
    	when(bookService.getBook(0)).thenReturn(designPatterns);
    }
	
	@Test
	public void testBookList() {
		assert(bookService.getBooks().size() > 0);
	}
	
	@Test
	public void testBookDetail() {
		Book book = bookService.getBook(0);
		assertEquals("Design Patterns", book.getTitle());
	}
}
