package com.rest.practice.service;

import java.util.List;

import com.rest.practice.models.MenuItem;

public interface MenuService {
	public MenuItem save(MenuItem menuItem);
	
	public MenuItem edit(Long id, MenuItem menuItem);

	public List<MenuItem> findAll();
	
	public void delete(long id);

	public MenuItem find(Long id);
}
