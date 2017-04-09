package de.workshops.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import de.workshops.model.UserRole;
import de.workshops.model.User;

public class UserMapper implements RowMapper<User> {
	private Map<String, User> users;
	
	public UserMapper(Map<String, User> users) {
        this.users = users;
    }
	
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
    	String username = rs.getString("username");
        User user = users.get(username);
        if (user == null) {
            user = new User();
            user.setUsername(username);
            user.setPassword(rs.getString("password"));
            user.setEnabled(rs.getBoolean("enabled"));

            users.put(username, user);
        }

        UserRole role = new UserRole();
        role.setUsername("username");
        role.setRole(rs.getString("role"));
        user.getRoles().add(role.getRole());

        return user;
    }
}
