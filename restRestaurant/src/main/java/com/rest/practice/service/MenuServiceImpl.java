package com.rest.practice.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.practice.models.MenuItem;
import com.rest.practice.repository.MenuItemRepository;

@Service
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuItemRepository menuRepository;
	
	@Override
	public MenuItem save(MenuItem menuItem) {
		menuRepository.save(menuItem);
		return menuItem;
	}
	
	@Override
	public List<MenuItem> findAll() {
		return menuRepository.findAll();
	}

	@Override
	public MenuItem edit(Long id, MenuItem updatedMenuItem) {
		MenuItem menuItem = menuRepository.findMenuItemById(id);
		if(menuItem != null) {
			updatedMenuItem.setId(id);
			BeanUtils.copyProperties(updatedMenuItem, menuItem);
			menuRepository.save(menuItem);
			
		} 
		return menuItem;
	}

	@Override
	public void delete(long id) {
		menuRepository.deleteById(id);
	}

	@Override
	public MenuItem find(Long id){
		return menuRepository.findMenuItemById(id);
	}

} 
 