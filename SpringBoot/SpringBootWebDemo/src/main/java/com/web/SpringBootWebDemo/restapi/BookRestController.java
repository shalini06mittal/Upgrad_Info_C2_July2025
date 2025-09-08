package com.web.SpringBootWebDemo.restapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.SpringBootWebDemo.constants.AppConstants;
import com.web.SpringBootWebDemo.entity.Book;
import com.web.SpringBootWebDemo.service.BookService;


@RestController
@RequestMapping("/books")
public class BookRestController {

	@Autowired
	private BookService bookService;

	@GetMapping(produces = {"application/json","application/xml"})
	public List<Book> getBooks(@RequestParam(required  = false) String author){ 
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
			return ResponseEntity.ok(map);

		}catch(RuntimeException e) {
			map.put(AppConstants.STATUS, AppConstants.FAILURE);
			map.put(AppConstants.ERROR	, e.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
		}
		
	}

	@PostMapping 
	public ResponseEntity<Object> addBook(@RequestBody Book book){ 
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
	@PutMapping 
	public ResponseEntity<Object> updateBook(@RequestBody Book book){ 
		System.out.println("Book "+book); 
		Map<String, Object> map = new HashMap<>(); 
		try { 
			map.put(AppConstants.STATUS, AppConstants.SUCCESS);
	
			map.put("book",bookService.updateBook(book) ); 
			return ResponseEntity.ok(map); 
			} 
		catch (RuntimeException e){ map.put(AppConstants.STATUS, AppConstants.FAILURE); 
		map.put("error",e.getMessage()); 
		return ResponseEntity.badRequest().body(map); 
		} 
		
	}
	@DeleteMapping ("/{id}") 
	public ResponseEntity<Object> deleteBook(@PathVariable int id){ 
		Map<String, Object> map = new HashMap<>(); 
		try {
			map.put(AppConstants.STATUS, AppConstants.SUCCESS); 
			if(bookService.deleteBook(id)) {
				map.put("message", "Book deleted successfully"); 
				return ResponseEntity.ok(map); } 
			} catch (RuntimeException e){
				map.put(AppConstants.STATUS, AppConstants.FAILURE); 
				map.put("error",e.getMessage()); } 
		return ResponseEntity.badRequest().body(map); 
		}
}














