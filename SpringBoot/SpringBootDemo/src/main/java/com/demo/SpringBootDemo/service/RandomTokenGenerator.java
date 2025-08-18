package com.demo.SpringBootDemo.service;



import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomTokenGenerator implements ITokenGenerator {

	public RandomTokenGenerator() {
		System.out.println("Random token constructor");
	}
	@Override
	public String generateToken() {
		// TODO Auto-generated method stub
		return "Token " +new Random().nextInt(1,10);
	}

}

