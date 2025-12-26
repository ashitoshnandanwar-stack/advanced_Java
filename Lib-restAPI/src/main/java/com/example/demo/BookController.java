package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController 
{
	List<Book> list = new ArrayList<>();
	
	@PostMapping
	public String add(@RequestBody Book book) 
	{
		list.add(book);
		return "Added Successfully";
	}
	
	@GetMapping
	public List<Book> viewAll()
	{
		return list;
	}
	
	@GetMapping("/{id}")
	public Book getByAdding(@PathVariable int id)
	{
		for(Book b : list)
		{
			if(b.getBookId() == id)
			{
				return b;
			}
		}
		return null;
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable int id, @RequestBody Book updateBook)
	{
		for(Book b : list)
		{
			if(b.getBookId() == id)
			{
				b.setBookName(updateBook.getBookName());
				b.setAuthor(updateBook.getAuthor());
				b.setPrice(updateBook.getPrice());
				
				return "updated";
			}
		}
		return "not found";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id)
	{
		Book bookToRemove = null;
		for(Book b : list)
		{
			if(b.getBookId() == id)
			{
				bookToRemove = b;
				break;
			}
		}
		
		if(bookToRemove != null)
		{
			list.remove(bookToRemove);
			return"Deleted";
		}
		return "not found";
	}
}
