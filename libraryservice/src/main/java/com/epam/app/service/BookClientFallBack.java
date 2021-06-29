package com.epam.app.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.epam.app.dto.BookDto;
import com.epam.app.model.Book;

@Component
public class BookClientFallBack implements BookClient {

	@Override
	public List<Book> getAll() {
		Book book = new Book("some title", "some author", "some category", "some publisher");
		return Arrays.asList(book);
	}

	@Override
	public Book getOne(int id) {
		return new Book("some title", "some author", "some category", "some publisher");
	}

	@Override
	public Book add(BookDto bookDto) {
		return new Book("couldn't add this", "some author", "some category", "some publisher");
	}

	@Override
	public void deletOne(int id) {
	}

}
