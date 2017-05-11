package de.workshops.controllers;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class GlobalControllerExceptionHandler {
	@ResponseStatus(value = HttpStatus.CONFLICT, reason="Data integrity violation")
	@ExceptionHandler(DataIntegrityViolationException.class)
    public void handleConflict() {
    }
}
