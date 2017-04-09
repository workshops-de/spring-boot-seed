package de.workshops.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import de.workshops.model.Publisher;

public class PublisherMapper implements RowMapper<Publisher> {
    public Publisher mapRow(ResultSet rs, int rowNum) throws SQLException {
        Publisher publisher = new Publisher();
        publisher.setId(rs.getInt("id"));
        publisher.setName(rs.getString("name"));
        publisher.setUrl(rs.getString("url"));
        
        return publisher;
    }
}
