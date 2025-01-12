package com.crud.exceptions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.crud.payloads.ApiResponse;
import com.crud.payloads.ErrorInfo;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorInfo> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) throws ResourceNotFoundException{
		String message = ex.getMessage();
		ErrorInfo ef = new ErrorInfo();
		ef.setErrorMessage(ex.getMessage());
		ef.setErrorCode(HttpStatus.NOT_FOUND.value());
		ef.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<>(ef,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	private ResponseEntity<ErrorInfo> handleMethodArgsNotValidException(MethodArgumentNotValidException ex){

		ErrorInfo ef = new ErrorInfo();
		
		String errorMsg = ex.getBindingResult().getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(", "));
		

		ef.setErrorCode(HttpStatus.BAD_REQUEST.value());
		ef.setErrorMessage(errorMsg);
		ef.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<>(ef,HttpStatus.BAD_REQUEST);
	}
	
	

}
