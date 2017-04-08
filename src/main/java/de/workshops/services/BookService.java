package de.workshops.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import de.workshops.model.Book;

@Component
public class BookService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Book> getBooks() {
		List<Book> books = jdbcTemplate.query("SELECT * FROM books b JOIN publishers p ON b.publisher_id = p.id", new BookMapper());
		
		return books;
	}
}
