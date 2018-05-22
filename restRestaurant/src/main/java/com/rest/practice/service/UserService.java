package com.rest.practice.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.rest.practice.models.User;

public interface UserService extends UserDetailsService{
	User findByUserName(String username);

	User save(User user);
	
	List<User> findAll();
}


