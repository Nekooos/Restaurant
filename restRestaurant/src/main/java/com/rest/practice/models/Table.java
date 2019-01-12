package com.rest.practice.models;

import javax.persistence.*;

@Entity
class Table {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private int id;

    @Column(name = "seats")
    private int seats;

    public Table() {

    }

    public Table(int id, int seats) {
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public int getSeats() {
        return seats;
    }
}
