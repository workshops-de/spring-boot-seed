package de.workshops.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import de.workshops.model.Publisher;

@Service
public class PublisherService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Publisher> getPublishers() {
		List<Publisher> publishers = jdbcTemplate.query("SELECT * FROM publishers", new PublisherMapper());
		
		return publishers;
	}
	
	public Publisher getPublisher(int id) {
		Publisher publisher =
				jdbcTemplate.query(
						"SELECT * FROM publishers WHERE id = ?",
						new Object[] { id },
						new PublisherMapper()
				).get(0);
		
		return publisher;
	}
}
