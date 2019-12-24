package com.rest.practice.service;

import com.rest.practice.Exception.InternalServerErrorException;
import com.rest.practice.Exception.RestaurantNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.practice.models.Restaurant;
import com.rest.practice.repository.RestaurantRepository;

@Component
public class RestaurantServiceImpl implements RestaurantService{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Override
	public Restaurant save(Restaurant restaurant) throws InternalServerErrorException {
		try {
			return restaurantRepository.save(restaurant);
		} catch (Exception e) {
			throw new InternalServerErrorException("save restaurant failed due to: " +e.getMessage());
		}
	}

	@Override
	public Restaurant edit(Long id, Restaurant updatedRestaurant) throws RestaurantNotFoundException {
		Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(
				() -> new RestaurantNotFoundException("Restaurant with id: " + id + "was not found, could not update"));
		BeanUtils.copyProperties(updatedRestaurant, restaurant);
		restaurantRepository.save(restaurant);
		return restaurant;
	}

	@Override
	public Restaurant get(Long id) throws RestaurantNotFoundException {
		return restaurantRepository.findById(id).orElseThrow(
				() -> new RestaurantNotFoundException("Restaurant with id: " + id + " was not found")
		);
	}
} 
