package com.fsd.stock.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsd.stock.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
