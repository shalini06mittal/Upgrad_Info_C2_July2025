package com.web.SpringBootWebDemo.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.SpringBootWebDemo.entity.Book;
import com.web.SpringBootWebDemo.service.BookService;

@RestController
@RequestMapping("/books")
public class BookRestController {

	@Autowired
	private BookService bookService;
	
	@GetMapping(produces = "application/json")
	public List<Book> getBooks(){ 
		return bookService.getAllBooks();
	}
}
