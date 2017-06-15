package de.workshops.services;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.workshops.TestingHelper;
import de.workshops.model.Book;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTests {
	
	@Mock
	private BookService bookService;
    
    @Before
    public void setup() {
    	TestingHelper.mockBookService(bookService);
    }
	
	@Test
	public void testGetBookList() {
		assertTrue(bookService.getBooks().size() > 0);
	}
	
	@Test
	public void testGetBookDetail() {
		Book book = bookService.getBook(0);
		assertEquals("Design Patterns", book.getTitle());
	}
}
