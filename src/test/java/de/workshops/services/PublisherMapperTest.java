package de.workshops.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import de.workshops.model.Publisher;

public class PublisherMapperTest {

	@Test
	public void test() throws SQLException {
		ResultSet resultSet = mock(ResultSet.class);
		when(resultSet.getInt("id")).thenReturn(0);
        when(resultSet.getString("name")).thenReturn("Addison-Wesley");
        when(resultSet.getString("url")).thenReturn("http://www.addison-wesley.de/");
        
        PublisherMapper publisherMapper = new PublisherMapper();
        Publisher publisher = publisherMapper.mapRow(resultSet, 1);
        
        assertTrue(0 == publisher.getId());
        assertEquals("Addison-Wesley", publisher.getName());
        assertEquals("http://www.addison-wesley.de/", publisher.getUrl());
	}

}
