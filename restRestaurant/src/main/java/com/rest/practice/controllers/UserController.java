package com.rest.practice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable ("id")Long id) {
		 userService.delete(id);
		 return ResponseEntity.status(200).body("Menu item was deleted succesfully");
	}
}
