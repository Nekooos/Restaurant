package com.rest.practice.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.practice.models.Restaurant;
import com.rest.practice.service.RestaurantService;

@RestController
@RequestMapping("restaurant")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantservice;
	
	@GetMapping("/{id}")
	public ResponseEntity<Restaurant> getRestaurant(@PathParam("id") long id) {
		Restaurant restaurant = restaurantservice.get(id);
		return ResponseEntity.status(200).body(restaurant);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Restaurant> saveRestaurant(Restaurant restaurant) {
		restaurantservice.save(restaurant);
		return ResponseEntity.status(201).body(restaurant);
	}
	
	@PutMapping("/edit")
	public ResponseEntity<Restaurant> editRestaurant(@PathParam("id") long id, Restaurant restaurant) {
		restaurantservice.edit(id, restaurant);
		return ResponseEntity.status(200).body(restaurant);
	}
}
