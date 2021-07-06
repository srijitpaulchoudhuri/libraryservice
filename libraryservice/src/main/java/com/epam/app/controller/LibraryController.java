package com.epam.app.controller;


import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.epam.app.dto.BookDto;
import com.epam.app.dto.UserDto;
import com.epam.app.model.Book;
import com.epam.app.model.User;
import com.epam.app.service.LibraryService;

@RestController
@RequestMapping("/api/library")
public class LibraryController {
	
	@Autowired
	private LibraryService libraryService;

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks(){
		return new ResponseEntity<>(libraryService.getAllBooks(),HttpStatus.OK);
	}
	
	@GetMapping("/books/{book_id}")
	public ResponseEntity<Book> getOneBook(@PathVariable("book_id") int bookId) throws Throwable{
		return new ResponseEntity<>(libraryService.getOneBook(bookId),HttpStatus.OK);
	}
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody BookDto bookDto){
		return new ResponseEntity<>(libraryService.addBook(bookDto),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/books/{book_id}")
	public ResponseEntity<Object> deleteOneBook(@PathVariable("book_id") int bookId){
		libraryService.deleteOneBook(bookId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<>(libraryService.getAllUsers(),HttpStatus.OK);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> addUser(@RequestBody UserDto userDto){
		return new ResponseEntity<>(libraryService.addUser(userDto),HttpStatus.CREATED);
	}
	
	@PutMapping("/users/{user_id}")
	public ResponseEntity<User> updateUser(@RequestBody UserDto userDto,@PathVariable("user_id") int userId){
		return new ResponseEntity<>(libraryService.updateUser(userDto, userId),HttpStatus.CREATED);
	}
	
	@GetMapping("/users/{user_id}")
	public ResponseEntity<User> getOneUser(@PathVariable("user_id") int userId){
		return new ResponseEntity<>(libraryService.getOneUser(userId),HttpStatus.OK);
	}
}

