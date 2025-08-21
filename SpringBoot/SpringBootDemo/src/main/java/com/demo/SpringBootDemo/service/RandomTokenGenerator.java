package com.demo.SpringBootDemo.service;



import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("ob")
public class RandomTokenGenerator implements ITokenGenerator {

	@Value("10")
	private int origin; 
	@Value("20")
	private int bound;

	public RandomTokenGenerator() {
		System.out.println("Random token constructor");
	}

	public int getOrigin() { return origin; } 
	public void setOrigin(int origin) { this.origin = origin; } 
	public int getBound() { return bound; } 
	public void setBound(int bound) { this.bound = bound; }
	@Override
	public String generateToken() {
		// TODO Auto-generated method stub
//		return "Token " +new Random().nextInt(1,10);
		return "Token " +new Random().nextInt(origin, bound);
	}

}

