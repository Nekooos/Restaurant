package com.rest.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rest.practice.models.MenuItem;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
	
	//@Query("SELECT m FROM MenuItem m WHERE id = :menuItemId")
	//MenuItem findMenuItemById (long id);

}
 