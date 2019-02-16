package com.rest.practice.models;

import javax.persistence.*;

@Entity
public class RestaurantTable {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private int id;

    @Column(name = "seats")
    private int seats;

    @Column(name = "booked")
    boolean booked;

    public RestaurantTable() {

    }

    public RestaurantTable(int id, int seats) {
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public int getSeats() {
        return seats;
    }

    public boolean isBooked() {
        return booked;
    }
    public void setBooked(boolean booked) {
        this.booked = booked;
    }
}
