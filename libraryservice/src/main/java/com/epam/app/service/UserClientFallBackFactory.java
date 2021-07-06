package com.epam.app.service;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

@Component
public class UserClientFallBackFactory implements FallbackFactory<UserClient>{

	@Override
	public UserClient create(Throwable cause) {
		return new UserClientFallBackCustom(cause);
	}
	

}
