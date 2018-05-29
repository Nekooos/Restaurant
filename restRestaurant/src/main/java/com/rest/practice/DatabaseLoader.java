package com.rest.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.rest.practice.models.User;
import com.rest.practice.repository.UserRepository;
//@Component
public class DatabaseLoader implements ApplicationRunner {
	
	private final UserRepository userRepository;
	
	@Autowired
	public DatabaseLoader(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("start");
		String[] roles = {"ROLE_ADMIN"};
		User user = new User();
		user.setFirstName("Mirre");
		user.setLastName("Mullvad");
		user.setPassword("pass");
		user.setUsername("user");
		user.setRoles(roles);
		userRepository.save(user);
		System.out.println("done");
		String[] temp = user.getRoles();
		System.out.println(temp[1]);
	}
	
}
