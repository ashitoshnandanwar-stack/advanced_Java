package com.example.demo;

public class Book 
{
	int bookId;
	String bookName;
	String author;
	String price;
	public Book() {
		
	}
	public Book(int bookId, String bookName, String author, String price) {
		
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
}
