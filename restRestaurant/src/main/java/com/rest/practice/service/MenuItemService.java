package com.rest.practice.service;

import java.util.List;

import com.rest.practice.Exception.MenuItemNotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;

import com.rest.practice.models.MenuItem;

public interface MenuItemService {
	
	@PreAuthorize("hasRole('ROLE_USER')")
	MenuItem save(MenuItem menuItem);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	MenuItem edit(long id, MenuItem menuItem) throws MenuItemNotFoundException;
	
	@PreAuthorize("hasRole('ROLE_USER')")
	void delete(long id);
	
	List<MenuItem> findAll();
	
	MenuItem find(Long id) throws MenuItemNotFoundException;

	void add(long itemId, long menuId);
}
