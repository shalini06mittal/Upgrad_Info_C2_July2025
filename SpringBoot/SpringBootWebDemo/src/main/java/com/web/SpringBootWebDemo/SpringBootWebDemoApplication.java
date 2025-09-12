package com.web.SpringBootWebDemo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.web.SpringBootWebDemo.entity.Book;
import com.web.SpringBootWebDemo.repo.BookRepo;

import jakarta.annotation.PostConstruct;

// front controller

//http://localhost:8081/swagger-ui/index.html

@SpringBootApplication
public class SpringBootWebDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebDemoApplication.class, args);
		
		
	}
	
	@Autowired
	private BookRepo bookRepo;
	
	//@PostConstruct
	public void addBook() {
		ArrayList<Book> bookList = new ArrayList<>();
		bookList.add( new Book("Core Java", "Hotsmann","Learn java fundamentals", 130.0));
		bookList.add( new Book("HTML", "Kelly","Learn html for UI", 230.0));
		bookList.add( new Book( "python", "ryan","Learn python fundamentals", 130.0));
		bookList.add( new Book( "css", "kelly","Learn css for designing webpage", 130.0));
		bookRepo.saveAll(bookList);
	}

}
