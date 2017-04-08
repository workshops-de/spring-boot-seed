package de.workshops.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import de.workshops.model.Book;

public class BookMapperTest {

	@Test
	public void test() throws SQLException {
		ResultSet resultSet = mock(ResultSet.class);
		when(resultSet.getString("title")).thenReturn("Design Patterns");
		when(resultSet.getString("subtitle")).thenReturn("Elements of Reusable Object-Oriented Software");
		when(resultSet.getString("isbn")).thenReturn("978-0-20163-361-0");
		when(resultSet.getString("abstract_text")).thenReturn("Capturing a wealth of experience about the design of object-oriented software, four top-notch designers present a catalog of simple and succinct solutions to commonly occurring design problems. Previously undocumented, these 23 patterns allow designers to create more flexible, elegant, and ultimately reusable designs without having to rediscover the design solutions themselves.");
		when(resultSet.getInt("num_pages")).thenReturn(395);
		when(resultSet.getString("author")).thenReturn("Erich Gamma / Richard Helm / Ralph E. Johnson / John Vlissides");
        when(resultSet.getString("name")).thenReturn("Addison-Wesley");
        when(resultSet.getString("url")).thenReturn("http://www.addison-wesley.de/");
        
        BookMapper bookMapper = new BookMapper();
        Book book = bookMapper.mapRow(resultSet, 1);
        
        assertEquals("Design Patterns", book.getTitle());
        assertEquals("Elements of Reusable Object-Oriented Software", book.getSubtitle());
        assertEquals("978-0-20163-361-0", book.getIsbn());
        assertEquals("Capturing a wealth of experience about the design of object-oriented software, four top-notch designers present a catalog of simple and succinct solutions to commonly occurring design problems. Previously undocumented, these 23 patterns allow designers to create more flexible, elegant, and ultimately reusable designs without having to rediscover the design solutions themselves.", book.getAbstractText());
        assert(395 == book.getNumPages());
        assertEquals("Erich Gamma / Richard Helm / Ralph E. Johnson / John Vlissides", book.getAuthor());
        assertEquals("Addison-Wesley", book.getPublisher().getName());
        assertEquals("http://www.addison-wesley.de/", book.getPublisher().getUrl());
	}

}
