package com.rest.practice.service;

import java.util.List;

import com.rest.practice.Exception.InternalServerErrorException;
import com.rest.practice.Exception.MenuItemNotFoundException;
import com.rest.practice.Exception.MenuNotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;

import com.rest.practice.models.MenuItem;

public interface MenuItemService {
	
	@PreAuthorize("hasRole('ROLE_USER')")
	MenuItem save(MenuItem menuItem);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	MenuItem edit(Long id, MenuItem menuItem) throws MenuItemNotFoundException, InternalServerErrorException;
	
	@PreAuthorize("hasRole('ROLE_USER')")
	void delete(Long id) throws MenuItemNotFoundException;
	
	List<MenuItem> findAll();
	
	MenuItem find(Long id) throws MenuItemNotFoundException;

	@PreAuthorize("hasRole('ROLE_USER')")
	void addToMenu(Long itemId, Long menuId) throws MenuItemNotFoundException, MenuNotFoundException;
}
