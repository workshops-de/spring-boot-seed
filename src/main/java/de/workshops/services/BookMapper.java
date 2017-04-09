package de.workshops.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import de.workshops.model.Book;
import de.workshops.model.Publisher;

public class BookMapper implements RowMapper<Book> {
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("book_id"));
        book.setTitle(rs.getString("title"));
        book.setSubtitle(rs.getString("subtitle"));
        book.setIsbn(rs.getString("isbn"));
        book.setAbstractText(rs.getString("abstract_text"));
        book.setNumPages(rs.getInt("num_pages"));
        book.setAuthor(rs.getString("author"));
        Publisher publisher = new Publisher();
        publisher.setId(rs.getInt("publisher_id"));
        publisher.setName(rs.getString("name"));
        publisher.setUrl(rs.getString("url"));
        book.setPublisher(publisher);
        
        return book;
    }
}
