package com.rest.practice.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.rest.practice.models.User;

public interface UserService extends UserDetailsService{
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	void save(User user);
	
	List<User> findAll();
}


