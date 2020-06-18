package com.fsd.stock.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fsd.stock.user.entity.User;
import com.fsd.stock.user.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserserviceApplicationTests {

	@Autowired
	private UserService userService;
	
	@Test
	public void getUserById() {
		userService.findById((long) 9999);
	}
	
	@Test
	public void getUserByName() {
		userService.findByUserName("william");
	}
	
	@Test
	public void getAll() {
		userService.findAll();
	}
	
	@Test
	public void saveUser() {
		User user = new User();
		user.setUsername("testname");
		user.setPassword("testpwd");
		userService.save(user);
	}
	
	@Test
	public void deleteUser() {
		User user = new User();
		user.setUsername("testname");
		user.setPassword("testpwd");
		userService.delete(user);
	}
}
