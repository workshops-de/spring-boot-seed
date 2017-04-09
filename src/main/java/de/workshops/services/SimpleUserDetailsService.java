package de.workshops.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import de.workshops.model.User;

@Service("userDetailsService")
public class SimpleUserDetailsService implements UserDetailsService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =
				jdbcTemplate.query(
						"SELECT u.username, u.password, u.enabled, ur.role FROM users u JOIN user_roles ur ON u.username = ur.username WHERE u.username = ? AND u.enabled = true",
						new Object[] { username },
						new UserMapper(new HashMap<String, User>())
				).get(0);
		
		return user;
	}
}
