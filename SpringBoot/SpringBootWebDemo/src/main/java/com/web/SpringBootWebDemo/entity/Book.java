package com.web.SpringBootWebDemo.entity;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
@Entity
public class Book {

	@Id
	private int bookid; 
	
	@NotNull(message = "Title must not be empty")
	private String title; 
	
	@Column(length = 100)//, columnDefinition = "varchar(100) default 'unknown'")
	@ColumnDefault("'unknown author'")
	private String author;
	
	@Column(name="description")
	private String desc; 
	
	@Positive(message = "Price must be positive")
	@Min(50)
	
	private double price;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int bookid, String title, String author, String desc, double price) {
		super();
		this.bookid = bookid;
		this.title = title;
		this.author = author;
		this.desc = desc;
		this.price = price;
	}

	public Book(String title, String author, String desc, double price) {
		super();
		this.title = title;
		this.author = author;
		this.desc = desc;
		this.price = price;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", title=" + title + ", author=" + author + ", desc=" + desc + ", price="
				+ price + "]";
	}
	
	
	
	
}
