package com.rest.practice.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.practice.models.Menu;
import com.rest.practice.models.MenuItem;
import com.rest.practice.repository.MenuItemRepository;
import com.rest.practice.repository.MenuRepository;

@Service
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuItemRepository menuItemRepository;
	
	@Autowired
	private MenuRepository menuRepository;
	
	@Override
	public MenuItem save(MenuItem menuItem) {
		menuItemRepository.save(menuItem);
		return menuItem;
	}
	
	@Override
	public List<MenuItem> findAll() {
		return menuItemRepository.findAll();
	}

	@Override
	public MenuItem edit(Long id, MenuItem updatedMenuItem) {
		MenuItem menuItem = menuItemRepository.findMenuItemById(id);
		if(menuItem != null) {
			updatedMenuItem.setId(id);
			BeanUtils.copyProperties(updatedMenuItem, menuItem);
			menuItemRepository.save(menuItem);
			
		} 
		return menuItem;
	}

	@Override
	public void delete(long id) {
		menuItemRepository.deleteById(id);
	}

	@Override
	public MenuItem find(Long id){
		return menuItemRepository.findMenuItemById(id);
	}

	@Override
	public void add(long itemId, long menuId) {
		MenuItem menuItem = menuItemRepository.findMenuItemById(itemId);
		Menu menu = menuRepository.findMenuById(menuId);
		//add item to menu
		//save
	}

} 
 