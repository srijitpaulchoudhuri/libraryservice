package com.epam.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.FeignException;

@RestControllerAdvice
@RestController
public class GlobalExceptionHandler {

	@ExceptionHandler(FeignException.NotFound.class)
	public ResponseEntity<ErrorResponseTemplate> handleException(FeignException e){
		ErrorResponseTemplate error;
		try {
			error = new ObjectMapper().readValue(e.contentUTF8(), ErrorResponseTemplate.class);
		}catch (JsonProcessingException jsonError) {
			error = new ErrorResponseTemplate("Something went wrong.Please try again", jsonError.getMessage());
		}
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
}
