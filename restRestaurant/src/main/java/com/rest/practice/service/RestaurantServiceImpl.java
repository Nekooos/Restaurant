package com.rest.practice.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.practice.models.Restaurant;
import com.rest.practice.repository.RestaurantRepository;

@Component
public class RestaurantServiceImpl implements RestaurantService{
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Override
	public Restaurant save(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}

	@Override
	public Restaurant edit(Long id, Restaurant updatedRestaurant) {
		Restaurant restaurant = restaurantRepository.findRestaurantById(id);
		if(restaurant != null) {
			updatedRestaurant.setId(id);
			BeanUtils.copyProperties(updatedRestaurant, restaurant);
			restaurantRepository.save(restaurant);
			
		} 
		return restaurant;
	}

	@Override
	public Restaurant get(Long id) {
		Restaurant restaurant = restaurantRepository.findRestaurantById(id);
		return restaurant;
	}
} 
