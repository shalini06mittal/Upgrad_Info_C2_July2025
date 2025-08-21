package com.demo.SpringBootDemo.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SimpleTokenGenerator implements ITokenGenerator{
	
	private static int counter;
	
	@Override
	public String generateToken() {
		return "Token " + ++counter;
	}
}
