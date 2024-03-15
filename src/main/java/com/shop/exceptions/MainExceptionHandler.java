package com.shop.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MainExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(MessageRuntimeException.class)
	public ResponseEntity<?> handleMessageRuntimeException(MessageRuntimeException ex) {
	    
		Map<String, String> errors = new HashMap<String, String>();
        errors.put("message", ex.getMessage());
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex,
			HttpHeaders headers,
			HttpStatusCode status,
			WebRequest request){
	    
		Map<String, String> errors = new HashMap<String, String>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
}