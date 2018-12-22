package com.rest.practice.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.rest.practice.models.MenuItem;

public interface MenuItemService {
	
	@PreAuthorize("hasRole('ROLE_USER')")
	public MenuItem save(MenuItem menuItem);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	public MenuItem edit(Long id, MenuItem menuItem);
	
	@PreAuthorize("hasRole('ROLE_USER')")
	public void delete(long id);
	
	public List<MenuItem> findAll();
	
	public MenuItem find(Long id);

	public void add(long itemId, long menuId);
}
