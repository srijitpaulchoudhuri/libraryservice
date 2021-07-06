package com.epam.app.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.epam.app.dto.UserDto;
import com.epam.app.model.User;

@FeignClient(name="user-service"/*,fallback = UserClientFallback.class*/,fallbackFactory = UserClientFallBackFactory.class)
public interface UserClient {

	@GetMapping("/api/users")
	public List<User> getAll();
	
	@PostMapping("/api/users")
	public User add(@RequestBody UserDto userDto); 
	
	@PutMapping("/api/users/{id}")
	public User update(@RequestBody UserDto userDto,@PathVariable int id);
	
	@GetMapping("/api/users/{id}")
	public User getOne(@PathVariable int id);
}
