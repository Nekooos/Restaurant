package com.rest.practice.repository;

import org.springframework.data.repository.CrudRepository;

import com.rest.practice.models.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long>{

}
