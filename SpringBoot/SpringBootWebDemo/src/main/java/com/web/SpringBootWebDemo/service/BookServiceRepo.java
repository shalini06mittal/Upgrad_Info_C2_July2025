package com.web.SpringBootWebDemo.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.SpringBootWebDemo.entity.Book;
import com.web.SpringBootWebDemo.repo.BookRepo;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class BookServiceRepo {

	@Autowired
	private BookRepo bookRepo;

	public BookServiceRepo() {
		System.out.println("Book service default constructor");

	} 
	public long getTotalBookCount(){ 
		return bookRepo.count(); 
	} 
	public List<Book> getAllBooks(){
		return bookRepo.findAll(); 
	} 
	public Book addNewBook(Book book){ 

		if(bookRepo.existsById(book.getBookid())) 
			throw new EntityExistsException("Book with id "+book.getBookid()+" already exists"); 

		return bookRepo.save(book); 
	} 
	public Book updateBook(Book book){
		if(!bookRepo.existsById(book.getBookid()))
			throw new EntityNotFoundException("cannot update "+book.getBookid()+" does not exist");
		
		return bookRepo.save(book); 
	} 
	public boolean deleteBook(int id){ 
		if(!bookRepo.existsById(id)) 
			throw new EntityNotFoundException("cannot delete "+id+" does not exist");
		bookRepo.deleteById(id); 
		return true; 
	} 
	public List<Book> getBooksByAuthor(String author){ 
		
		return null;
	} 
	public Book getBookById(int id){ 
		if(!bookRepo.existsById(id)) 
			throw new EntityNotFoundException(id+" not found"); 
		return bookRepo.findById(id).get();
	}
}
