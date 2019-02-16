package com.rest.practice.service;

import com.rest.practice.models.RestaurantTable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BookingServiceImpl implements Bookingservice{
    @Override
    public List<RestaurantTable> findAll() {
        List<RestaurantTable> tables2 = new ArrayList<>();
        CompletableFuture<List<RestaurantTable>> tables = null;
        return tables2;
    }

    @Override
    public RestaurantTable getRestaurantTablebyId(Long Id) {
        return null;
    }

    @Override
    public RestaurantTable save(RestaurantTable restaurantTable) {
        return null;
    }
}
