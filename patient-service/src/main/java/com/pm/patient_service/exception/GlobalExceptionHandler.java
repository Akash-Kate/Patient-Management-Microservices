package com.pm.patient_service.exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	
	
	private static final Logger log = LoggerFactory.getLogger(
			GlobalExceptionHandler.class
		);

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
		Map<String, String> erros = new HashMap<>();

		ex.getBindingResult().getFieldErrors().forEach(error -> erros.put(error.getField(), error.getDefaultMessage()));

		return ResponseEntity.badRequest().body(erros);
	}

	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<Map<String, String>> handleEmailAlreadyExistsException(EmailAlreadyExistsException ex) {

		log.warn("Email Address already exist {} ",ex.getMessage());
		
		Map<String,String> errors = new HashMap<>();
		errors.put("message", "Email Address already exists");
		
		return ResponseEntity.badRequest().body(errors);
	}

}
