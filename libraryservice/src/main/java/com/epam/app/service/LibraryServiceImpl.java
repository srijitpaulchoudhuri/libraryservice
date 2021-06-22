package com.epam.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.app.dto.BookDto;
import com.epam.app.dto.UserDto;
import com.epam.app.model.Book;
import com.epam.app.model.User;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	@Autowired
	private BookClient bookClient;
	@Autowired
	private UserClient userClient;

	@Override
	public List<Book> getAllBooks() {
		return bookClient.getAll();
	}

	@Override
	public Book getOneBook(int id){
		return bookClient.getOne(id);
	}

	@Override
	public Book addBook(BookDto bookDto) {
		return bookClient.add(bookDto);
	}

	@Override
	public void deleteOneBook(int id) {
		bookClient.deletOne(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userClient.getAll();
	}

	@Override
	public User addUser(UserDto userDto) {
		return userClient.add(userDto);
	}

	@Override
	public User updateUser(UserDto userDto, int id) {
		return userClient.update(userDto, id);
	}

	@Override
	public User getOneUser(int id) {
		return userClient.getOne(id);
	}

}
