package de.workshops.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserRole {
	@JsonIgnore
	Integer id;
	String username;
    String role;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
