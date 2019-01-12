package com.rest.practice;

import com.rest.practice.models.Menu;
import com.rest.practice.models.Restaurant;
import com.rest.practice.repository.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MockRestaurantRepository implements RestaurantRepository {
    List<Menu> menu = new ArrayList();
    Optional<Restaurant> restaurant = Optional.of(new Restaurant("Bubbas Kött", "fisk", 070666666, "Delfingatan 8 A 333 33 Dolphinville", menu));

    @Override
    public <S extends Restaurant> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    public Optional<Restaurant> findById(Long id) {
        return restaurant;
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Restaurant> findAll() {
        return null;
    }

    @Override
    public Iterable<Restaurant> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Restaurant entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends Restaurant> entities) {

    }

    @Override
    public void deleteAll() {

    }

    public Restaurant save(Restaurant restaurant) {
        return restaurant;
    }
}
