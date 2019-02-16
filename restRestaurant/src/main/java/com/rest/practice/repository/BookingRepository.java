package com.rest.practice.repository;

import com.rest.practice.models.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<RestaurantTable, Long> {

}
