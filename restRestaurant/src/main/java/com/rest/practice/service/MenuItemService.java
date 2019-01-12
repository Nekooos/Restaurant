package com.rest.practice.service;

import java.net.ConnectException;
import java.util.List;

import com.rest.practice.Exception.InternalServerErrorException;
import com.rest.practice.Exception.MenuItemNotFoundException;
import com.rest.practice.Exception.MenuNotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;

import com.rest.practice.models.MenuItem;

public interface MenuItemService {

	MenuItem save(MenuItem menuItem) throws InternalServerErrorException;

	MenuItem edit(Long id, MenuItem menuItem) throws MenuItemNotFoundException, InternalServerErrorException;

	void delete(Long id) throws MenuItemNotFoundException, ConnectException;
	
	List<MenuItem> findAll();
	
	MenuItem find(Long id) throws MenuItemNotFoundException;

	void addToMenu(Long itemId, Long menuId) throws MenuItemNotFoundException, MenuNotFoundException;
}
