package com.epam.app.service;

import java.util.Arrays;
import java.util.List;

import com.epam.app.dto.BookDto;
import com.epam.app.model.Book;
import com.netflix.hystrix.exception.HystrixTimeoutException;

import feign.FeignException;

public class BookClientFallBackWithError implements BookClient {
	
	private Throwable cause;
	
	public BookClientFallBackWithError(Throwable cause) {
		this.cause = cause;
	}

	@Override
	public List<Book> getAll() {
		if(cause instanceof HystrixTimeoutException) {
			return Arrays.asList(new Book("some title", "some author", "some category", "some publisher"));
		}
		return Arrays.asList();
	}

	@Override
	public Book getOne(int id) throws Throwable {
		Book book = null;
		if(cause instanceof HystrixTimeoutException) {
			return new Book("some title", "some author", "some category", "some publisher");
		}
		if(((FeignException)cause).status()==404) {
			throw (FeignException.NotFound)cause;
		}
		return book;
	}

	@Override
	public Book add(BookDto bookDto) {
		if(cause instanceof HystrixTimeoutException) {
			return new Book("some title", "some author", "some category", "some publisher");
		}
		return null;
	}

	@Override
	public void deletOne(int id) {
		// TODO Auto-generated method stub

	}

}
