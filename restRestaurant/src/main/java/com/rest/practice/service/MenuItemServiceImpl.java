package com.rest.practice.service;

import java.util.List;
import java.util.concurrent.Future;

import com.rest.practice.Exception.CantAccessDatabseException;
import com.rest.practice.Exception.InternalServerErrorException;
import com.rest.practice.Exception.MenuItemNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.practice.models.Menu;
import com.rest.practice.models.MenuItem;
import com.rest.practice.repository.MenuItemRepository;
import com.rest.practice.repository.MenuRepository;

@Service
public class MenuItemServiceImpl implements MenuItemService{
	
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
	public MenuItem edit(long id, MenuItem updatedMenuItem) throws MenuItemNotFoundException, InternalServerErrorException {
		try {
			MenuItem menuItem = menuItemRepository.findMenuItemById(id);
			if (menuItem.getId() == id) {
				updatedMenuItem.setId(id);
				BeanUtils.copyProperties(updatedMenuItem, menuItem);
				menuItemRepository.save(menuItem);
				return menuItem;
			} else if (menuItem.getId() != id) {
				throw new MenuItemNotFoundException("Menu item was not found");
			} else {
				// Todo find and catch database exception
				throw new CantAccessDatabseException("No connection to database");
			}
		} catch(Exception e) {
			throw new InternalServerErrorException(e.getMessage());
		}
	}

	@Override
	public void delete(long id) {
		menuItemRepository.deleteById(id);
	}

	@Override
	public MenuItem find(Long id){

		MenuItem menuItem = menuItemRepository.findMenuItemById(id);
		return menuItem;
	}

	@Override
	public void add(long itemId, long menuId) {
		MenuItem menuItem = menuItemRepository.findMenuItemById(itemId);
		Menu menu = menuRepository.findMenuById(menuId);
		menu.getMenuitems().add(menuItem);
		menuRepository.save(menu);
	}

} 
 