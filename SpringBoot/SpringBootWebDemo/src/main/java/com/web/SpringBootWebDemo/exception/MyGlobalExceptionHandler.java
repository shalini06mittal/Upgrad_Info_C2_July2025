package com.web.SpringBootWebDemo.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.web.SpringBootWebDemo.constants.AppConstants;

import io.swagger.v3.oas.annotations.Hidden;

@ControllerAdvice
@Hidden
public class MyGlobalExceptionHandler {

	public MyGlobalExceptionHandler() {
		System.out.println("my global exception handler");
	}
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Object> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex){
		System.out.println("HttpRequestMethodNotSupportedException exception handled at application level");
		Map<String, Object> map = new HashMap<>();
		map.put(AppConstants.STATUS, AppConstants.FAILURE);
		map.put(AppConstants.ERROR	, ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<Object> handleGenericException(Exception ex){
//		System.out.println("Exception exception handled at application level");
//		ex.printStackTrace();
//		Map<String, Object> map = new HashMap<>();
//		map.put(AppConstants.STATUS, AppConstants.FAILURE);
//		map.put(AppConstants.ERROR	, ex.getMessage());
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
//	}
	@ExceptionHandler({Exception.class, MethodArgumentNotValidException.class}) 
	public ResponseEntity<Object> handleException(Exception ex){ 
		Map<String, Object> map = new HashMap<>(); 
		map.put(AppConstants.STATUS, AppConstants.FAILURE);
		if(ex instanceof MethodArgumentNotValidException){ 
			String msg = ((MethodArgumentNotValidException) ex).getAllErrors() 
					.stream()
					.map(ObjectError::getDefaultMessage) 
					.collect(Collectors.joining(","));
			map.put("error",msg); 
			return ResponseEntity.badRequest().body(map); 
			} 
		System.out.println("general exception"); 
		System.out.println(ex.getMessage()); 
		map.put("error",ex.getMessage()); 
		return ResponseEntity.badRequest().body(map); }
}
