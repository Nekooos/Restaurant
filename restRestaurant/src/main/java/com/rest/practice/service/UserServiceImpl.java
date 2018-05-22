package com.rest.practice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rest.practice.models.User;
import com.rest.practice.repository.UserRepository;;
@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findByUserName(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user == null) {
			LOG.warn("Username {} not found, username");
			throw new UsernameNotFoundException("Username " + username+ " not found");
		}
		return user;
	}


	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}
}
