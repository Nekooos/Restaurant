package com.rest.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.practice.models.MenuItem;

@Repository
public interface MenuItemDao extends JpaRepository<MenuItem, Long> {
	
	
}
 