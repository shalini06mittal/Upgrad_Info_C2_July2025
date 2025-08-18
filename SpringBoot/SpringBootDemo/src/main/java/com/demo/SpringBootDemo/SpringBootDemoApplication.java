package com.demo.SpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// is an opinionated framework
@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		System.out.println("Hello Spring");
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

}
