package com.rest.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import com.rest.practice.models.User;
import com.rest.practice.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationRunner {
	
	private final UserRepository userRepository;
	
	@Autowired
	public DatabaseLoader(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		String[] roles = {"ROLE_ADMIN"};
		User user = new User();
		user.setFirstName("admin");
		user.setLastName("admin");
		user.setPassword("admin");
		user.setUsername("admin");
		user.setRoles(roles);
		userRepository.save(user);
	}
	
}
