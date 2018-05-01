package com.rest.practice.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.rest.practice.models.User;

public interface UserService extends UserDetailsService{
	User findByUserName(String username);
}
