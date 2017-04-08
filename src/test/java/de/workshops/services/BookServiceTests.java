package de.workshops.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.workshops.services.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTests {

	@Autowired
	private BookService bookService;
	
	@Test
	public void test() {
		assert(bookService.getBooks().size() > 0);
	}
}
