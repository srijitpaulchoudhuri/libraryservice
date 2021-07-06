package com.epam.app.service;

import java.util.List;

import com.epam.app.dto.BookDto;
import com.epam.app.dto.UserDto;
import com.epam.app.model.Book;
import com.epam.app.model.User;

public interface LibraryService {

	public List<Book> getAllBooks();
	public Book getOneBook(int id) throws Throwable;
	public Book addBook(BookDto bookDto);
	public void deleteOneBook(int id);
	public List<User> getAllUsers();
	public User addUser(UserDto userDto);
	public User updateUser(UserDto userDto,int id);
	public User getOneUser(int id);
}
