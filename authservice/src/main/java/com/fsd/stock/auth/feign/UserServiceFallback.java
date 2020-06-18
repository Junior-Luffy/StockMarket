package com.fsd.stock.auth.feign;

import org.springframework.stereotype.Component;

import com.fsd.stock.auth.model.AuthUser;

@Component
public class UserServiceFallback implements UserFeignClient {

	@Override
	public AuthUser getUserByName(String username) {
		// TODO Auto-generated method stub
		return new AuthUser(null, null, null, null, null, null, null);
	}

}
