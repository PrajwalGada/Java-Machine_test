package com.boot.anilg.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.boot.anilg.exception.BookNotFoundException;
import com.boot.anilg.exception.ErrorDetails;

@RestControllerAdvice
public class ProductExceptionHandler {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<?> handleProductNotFoundException(ProductNotFoundException exception, WebRequest request){
		ErrorDetails details  = new ErrorDetails(exception.getMessage(), new Date(), request.getContextPath());
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception exception, WebRequest request){
		ErrorDetails details  = new ErrorDetails(exception.getMessage(), new Date(), request.getContextPath());
		return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
