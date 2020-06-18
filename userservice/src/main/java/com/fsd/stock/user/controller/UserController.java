package com.fsd.stock.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsd.stock.user.entity.User;
import com.fsd.stock.user.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public List<User> getAll() {
		return userService.findAll();
	}
	
	@GetMapping("/user/{id}")
	public User getById(@PathVariable Long id) {
		return userService.findById(id);
	}
	
	@GetMapping("/username/{username}")
	public User getByUsername(@PathVariable String username) {
		return userService.findByUserName(username);
//		User user = new User();
//		user.setUserName("william");
//		user.setPassword("{bcrypt}$2a$10$L8cQUQmIpO3LKNGAfN7j0.CVBoznEcKRICw8TkKMvmdowCHI8EsW.");
//		user.setUserType("admin");
//		return user;
	}
	
	@PostMapping("/user/save")
	public User save(@RequestBody User user) {
		return userService.save(user);
	}
}
