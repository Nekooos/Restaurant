package com.rest.practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.rest.practice.models.MenuItem;
import com.rest.practice.repository.MenuItemDao;

@Component
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
	public MenuItem edit(long id, MenuItem menuItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		menuRepository.deleteById(id);
	}

	@Override
	public Optional<MenuItem> find(Long id){
		return menuRepository.findById(id);
	}

}
 