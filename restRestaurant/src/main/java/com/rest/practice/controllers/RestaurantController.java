package com.rest.practice.controllers;

import javax.websocket.server.PathParam;

import com.rest.practice.Exception.InternalServerErrorException;
import com.rest.practice.Exception.RestaurantNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.practice.models.Restaurant;
import com.rest.practice.service.RestaurantService;

import java.util.Optional;

@RestController
@RequestMapping("restaurant")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Restaurant> getRestaurant(@PathParam("id") long id) {
		Restaurant restaurant;
		try {
			 restaurant = restaurantService.get(id);
		} catch (RestaurantNotFoundException e) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.status(200).body(restaurant);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Restaurant> saveRestaurant(Restaurant restaurant){
		try {
			restaurantService.save(restaurant);
		} catch (InternalServerErrorException e) {
			ResponseEntity.status(500).build();
		}
		return ResponseEntity.status(201).body(restaurant);
	}
	
	@PutMapping("/edit")
	public ResponseEntity<Restaurant> editRestaurant(@PathParam("id") long id, Restaurant restaurant) {
		try {
			restaurantService.edit(id, restaurant);
		} catch (RestaurantNotFoundException e) {
			//todo make conflict exception
			return ResponseEntity.status(409).build();
		}
		return ResponseEntity.status(200).body(restaurant);
	}
}
