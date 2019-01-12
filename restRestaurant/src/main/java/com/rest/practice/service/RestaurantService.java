package com.rest.practice.service;

import com.rest.practice.Exception.InternalServerErrorException;
import com.rest.practice.Exception.RestaurantNotFoundException;
import com.rest.practice.models.Restaurant;

public interface RestaurantService {

	Restaurant save(Restaurant restaurant) throws InternalServerErrorException;

	Restaurant edit(Long id, Restaurant restaurant) throws RestaurantNotFoundException;

	Restaurant get(Long id) throws RestaurantNotFoundException;

}
