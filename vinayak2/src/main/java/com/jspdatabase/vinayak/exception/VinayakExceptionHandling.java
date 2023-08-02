package com.jspdatabase.vinayak.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class VinayakExceptionHandling {


	  @ExceptionHandler(MethodArgumentNotValidException.class) public
	  ResponseEntity<String>
	  handleValidationException(MethodArgumentNotValidException ex) { StringBuilder
	  errorMessage = new StringBuilder("Username ");
	  ex.getBindingResult().getAllErrors().forEach(error ->
	  errorMessage.append(error.getDefaultMessage()).append("; ")); return
	  ResponseEntity.badRequest().body(errorMessage.toString());}
	  
	  @ExceptionHandler(Exception.class) public ResponseEntity<String>
	  handleException(Exception ex) { return
	  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	  .body(ex.getMessage());
	  
	  }
}
