package com.web.SpringBootWebDemo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.web.SpringBootWebDemo.constants.AppConstants;

@ControllerAdvice
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
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleGenericException(Exception ex){
		System.out.println("Exception exception handled at application level");
		Map<String, Object> map = new HashMap<>();
		map.put(AppConstants.STATUS, AppConstants.FAILURE);
		map.put(AppConstants.ERROR	, ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
}
