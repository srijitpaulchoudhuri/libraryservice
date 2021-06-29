package com.epam.app.service;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

@Component
public class BookClientFallBackFactory implements FallbackFactory<BookClient>{

	@Override
	public BookClient create(Throwable cause) {
		return new BookClientFallBackWithError(cause);
	}

}
