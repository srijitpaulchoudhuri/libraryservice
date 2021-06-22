package com.epam.app.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.epam.app.dto.BookDto;
import com.epam.app.model.Book;

@FeignClient(name="book-service")
public interface BookClient {

	@GetMapping("/api/books")
	public List<Book> getAll();
	
	@GetMapping("/api/books/{id}")
	public Book getOne(@PathVariable int id);
	
	@PostMapping("/api/books")
	public Book add(@RequestBody BookDto bookDto);
	
	@DeleteMapping("/api/books/{id}")
	public void deletOne(@PathVariable int id);
	
}
