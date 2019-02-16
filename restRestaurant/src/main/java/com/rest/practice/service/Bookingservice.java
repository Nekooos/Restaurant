package com.rest.practice.service;

import com.rest.practice.models.MenuItem;
import com.rest.practice.models.RestaurantTable;

import javax.websocket.server.PathParam;
import java.util.List;

public interface Bookingservice {
    List<RestaurantTable> findAll();

    RestaurantTable getRestaurantTablebyId(@PathParam("id") Long Id);

    RestaurantTable save(RestaurantTable restaurantTable);
}
