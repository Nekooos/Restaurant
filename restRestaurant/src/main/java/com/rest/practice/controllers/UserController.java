package com.rest.practice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.practice.models.User;
import com.rest.practice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/all")
	public List<User> getAllUsers() {
		
		List<User> list = userService.findAll();
		return list;
	}
	
	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		 user = userService.save(user);
		 return ResponseEntity.status(201).body(user);
	}
	
}
