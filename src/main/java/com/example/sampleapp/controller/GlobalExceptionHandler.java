package com.example.sampleapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
		log.error(exception.getMessage(), exception);
		return new ResponseEntity<String>(exception.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleRuntimeException(RuntimeException exception){
		log.error(exception.getMessage(), exception);
		return new ResponseEntity<String>(exception.getLocalizedMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception exception){
		log.error(exception.getMessage(), exception);
		return new ResponseEntity<String>(exception.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
