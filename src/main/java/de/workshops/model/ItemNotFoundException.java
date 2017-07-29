package de.workshops.model;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="Item doesn't exist")
public class ItemNotFoundException extends RuntimeException {
	
}
