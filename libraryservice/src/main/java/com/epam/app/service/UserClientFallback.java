package com.epam.app.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.epam.app.dto.UserDto;
import com.epam.app.model.User;

@Component
public class UserClientFallback implements UserClient{

	@Override
	public List<User> getAll() {
		User user = new User("Some name", "Some username", "Some password");
		return Arrays.asList(user);
	}

	@Override
	public User add(UserDto userDto) {
		return new User("can't add this name", "can't add this username", "can't add this password");
	}

	@Override
	public User update(UserDto userDto, int id) {
		return new User("Some name", "Some username", "Some password");
	}

	@Override
	public User getOne(int id) {
		return new User("Some name", "Some username", "Some password");
	}

	
}
