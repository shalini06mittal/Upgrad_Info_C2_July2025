package com.web.SpringBootWebDemo;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.web.SpringBootWebDemo.entity.Book;

// front controller

//http://localhost:8081/swagger-ui/index.html

@SpringBootApplication
public class SpringBootWebDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebDemoApplication.class, args);
		
//		bookList = new ArrayList<>();
//		bookList.add( new Book(1, "Core Java", "Hotsmann","Learn java fundamentals", 130.0));
//		bookList.add( new Book(2,"HTML", "Kelly","Learn html for UI", 230.0));
//		bookList.add( new Book( 3, "python", "ryan","Learn python fundamentals", 130.0));
//		bookList.add( new Book( 4, "css", "kelly","Learn css for designing webpage", 130.0));
	}

}
