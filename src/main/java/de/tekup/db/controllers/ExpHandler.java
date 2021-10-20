package de.tekup.db.controllers;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExpHandler {
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNSEE(NoSuchElementException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
								.body("Error in search : "+e.getMessage());
	}

}
