package com.fsd.stock.auth.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fsd.stock.auth.model.AuthUser;

@FeignClient(value = "user-service",fallback = UserServiceFallback.class)
public interface UserFeignClient {
	
	@RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
	AuthUser getUserByName(@PathVariable("username") String username);

}