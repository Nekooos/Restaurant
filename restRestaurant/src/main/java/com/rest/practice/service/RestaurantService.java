package com.rest.practice.service;

import com.rest.practice.models.Restaurant;

public interface RestaurantService {

	Restaurant save(Restaurant restaurant);

	Restaurant edit(Long id,Restaurant restaurant);

	Restaurant get(Long id);
	
}
