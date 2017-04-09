package de.workshops.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Publisher {
	@JsonIgnore
	Integer id;
	String name;
	String url;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
