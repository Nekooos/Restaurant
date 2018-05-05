package com.rest.practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.rest.practice.models.MenuItem;
import com.rest.practice.repository.MenuItemDao;

@Service
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuItemDao menuRepository;
	
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
			System.out.println("updated item " + updatedMenuItem.toString());
			System.out.println("current db item " + menuItem.toString());
			BeanUtils.copyProperties(updatedMenuItem, menuItem);
			System.out.println("merged item:  " + menuItem.toString());
			menuRepository.save(menuItem);
			return menuItem;
		} 
		// Replace null throw new MenuItemNotFoundException 
		return null;
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
 