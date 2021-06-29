package com.epam.app.service;

import java.util.Arrays;
import java.util.List;

import com.epam.app.dto.UserDto;
import com.epam.app.model.User;
import com.netflix.hystrix.exception.HystrixTimeoutException;

import feign.FeignException;

public class UserClientFallBackCustom implements UserClient {
	
	private Throwable cause;
	
	public UserClientFallBackCustom(Throwable cause) {
		this.cause = cause;
	}

	@Override
	public List<User> getAll() {
		if(cause instanceof HystrixTimeoutException) {
			return Arrays.asList(new User("Some name", "Some username", "Some password"));
		}
		return Arrays.asList();
	}

	@Override
	public User add(UserDto userDto) {
		System.out.println(cause);
		if(cause instanceof HystrixTimeoutException) {
			return new User("Some name", "Some username", "Some password");
		}
		return new User("something","went","wrong");
	}

	@Override
	public User update(UserDto userDto, int id) {
		if(cause instanceof HystrixTimeoutException) {
			return new User("Some name", "Some username", "Some password");
		}
		if(cause instanceof FeignException && ((FeignException)cause).status()==404 ) {
			throw (FeignException.NotFound)cause;
		}
		return new User("something","went","wrong");
	}

	@Override
	public User getOne(int id) {
		if(cause instanceof HystrixTimeoutException) {
			return new User("Some name", "Some username", "Some password");
		}
		if(cause instanceof FeignException && ((FeignException)cause).status()==404 ) {
			throw (FeignException.NotFound)cause;
		}
		return new User("something","went","wrong");
	}

}
