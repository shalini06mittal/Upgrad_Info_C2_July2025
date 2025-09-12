package com.web.SpringBootWebDemo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.web.SpringBootWebDemo.entity.Book;

/**
 * 1. CrudRepository : basic CRUD
 * 2. PagingAndSortingRepository 
 * 3. JpaRepository : provides all the functionalities from the above
 * 2 interfaces
 */
public interface BookRepo extends JpaRepository<Book, Integer>{

	// custom queries
	public List<Book> findAllByAuthor(String author);
	// get all the books greater than a certain price
	public List<Book> findAllByPriceGreaterThan(double price);
}
