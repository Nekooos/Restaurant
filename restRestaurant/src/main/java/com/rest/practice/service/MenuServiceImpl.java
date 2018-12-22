package com.rest.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.practice.models.Menu;
import com.rest.practice.repository.MenuRepository;

@Component
public class MenuServiceImpl implements MenuService{
	@Autowired
	private MenuRepository MenuRepository;
	
	@Override
	public void save(Menu menu) {
		MenuRepository.save(menu);
	}

	@Override
	public Menu find(long id) {
		
		return null;
	}
	
}
