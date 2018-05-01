package com.rest.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.rest.practice.models.User;
import com.rest.practice.repository.UserDao;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User findByUserName(String username) {
		return userDao.findByUsername(username);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return user;
	}
}
