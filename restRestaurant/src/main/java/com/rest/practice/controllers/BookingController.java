package com.rest.practice.controllers;


import com.rest.practice.models.RestaurantTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/table")
public class BookingController {

    @Autowired


    @GetMapping("/all")
    public void getAllTables() {

    }

    @PostMapping("/save")
    public RestaurantTable save(RestaurantTable restaurantTable) {

        return restaurantTable;
    }
}
