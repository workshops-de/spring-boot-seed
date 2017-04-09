package de.workshops.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import de.workshops.model.Book;

@Component
public class BookService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Book> getBooks() {
		List<Book> books = jdbcTemplate.query("SELECT b.title, b.subtitle, b.isbn, b.abstract_text, b.num_pages, b.author, b.publisher_id, b.id AS book_id, p.name, p.url FROM books b JOIN publishers p ON b.publisher_id = p.id", new BookMapper());
		
		return books;
	}
	
	public Book getBook(int id) {
		Book book =
				jdbcTemplate.query(
						"SELECT b.title, b.subtitle, b.isbn, b.abstract_text, b.num_pages, b.author, b.publisher_id, b.id AS book_id, p.name, p.url FROM books b JOIN publishers p ON b.publisher_id = p.id WHERE b.id = ?",
						new Object[] { id },
						new BookMapper()
				).get(0);
		
		return book;
	}
	
	public Book createBook(final Book book) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(
                		"INSERT INTO books (title, subtitle, isbn, abstract_text, num_pages, author, publisher_id) VALUES (?, ?, ?, ?, ?, ?, ?)",
                		Statement.RETURN_GENERATED_KEYS
        		);

                preparedStatement.setString(1, book.getTitle());
                preparedStatement.setString(2, book.getSubtitle());
                preparedStatement.setString(3, book.getIsbn());
                preparedStatement.setString(4, book.getAbstractText());
                preparedStatement.setInt(5, book.getNumPages());
                preparedStatement.setString(6, book.getAuthor());
                preparedStatement.setInt(7, book.getPublisher().getId());

                return preparedStatement;
            }
        };
        jdbcTemplate.update(
                preparedStatementCreator,
                keyHolder
        );
        
        return getBook(keyHolder.getKey().intValue());
	}
	
	public Book updateBook(Book book) {
        jdbcTemplate.update(
                "UPDATE books SET title = ?, subtitle = ?, isbn = ?, abstract_text = ?, num_pages = ?, author = ?, publisher_id = ? WHERE id = ?",
                new Object[] {
                		book.getTitle(),
                		book.getSubtitle(),
                		book.getIsbn(),
                		book.getAbstractText(),
                		book.getNumPages(),
                		book.getAuthor(),
                		book.getPublisher().getId(),
                		book.getId()
                }
        );
        
        return getBook(book.getId().intValue());
	}
	
    public void deleteBook(int id) {
        jdbcTemplate.update(
        		"DELETE FROM books WHERE id = ?",
        		new Object[] { id }
		);
    }
}
