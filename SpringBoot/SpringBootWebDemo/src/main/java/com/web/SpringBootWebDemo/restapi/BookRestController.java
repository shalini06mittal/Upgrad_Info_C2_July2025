package com.web.SpringBootWebDemo.restapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.SpringBootWebDemo.constants.AppConstants;
import com.web.SpringBootWebDemo.entity.Book;
import com.web.SpringBootWebDemo.service.BookService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/books")
public class BookRestController {

	@Autowired
	private BookService bookService;
	
	@GetMapping(produces = "application/json")
	public List<Book> getBooks(@RequestParam(defaultValue ="kelly") String author){ 
		if(author==null)  
				return bookService.getAllBooks();
		return bookService.getBooksByAuthor(author);
	}
	
	//http://localhost:8081/books/1
//	@GetMapping("/{id}")
//	public Book getBookById(@PathVariable int id){
//		return bookService.getBookById(id);
//	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getBookById(@PathVariable int id){
		Map<String, Object> map = new HashMap<>();
		
		try {
			
			Book book =	bookService.getBookById(id);
			map.put(AppConstants.STATUS, AppConstants.SUCCESS);
			map.put("book", book);
			
		}catch(RuntimeException e) {
			map.put(AppConstants.STATUS, AppConstants.FAILURE);
			map.put(AppConstants.ERROR	, e.getMessage());
		}
		return ResponseEntity.ok(map);
	}
	
	@PostMapping 
	
	public ResponseEntity<Object> addBook( Book book){ 
		System.out.println("Book "+book); 
		Map<String, Object> map = new HashMap<>(); 
		try { 
			Book newbook = bookService.addNewBook(book);
			map.put(AppConstants.STATUS, AppConstants.SUCCESS);
			map.put("book", newbook); 
			return ResponseEntity.ok(map); 
		} catch (RuntimeException e){ 
			map.put(AppConstants.STATUS, AppConstants.FAILURE); 
			map.put(AppConstants.ERROR	,e.getMessage()); 
			return ResponseEntity.badRequest().body(map); 
			}
		}
}














