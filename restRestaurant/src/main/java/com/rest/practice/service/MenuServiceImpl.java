package com.rest.practice.service;

import com.rest.practice.Exception.MenuNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.practice.models.Menu;
import com.rest.practice.repository.MenuRepository;

import java.util.Optional;

@Component
public class MenuServiceImpl implements MenuService{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MenuRepository menuRepository;
	
	@Override
	public void save(Menu menu) {
		menuRepository.save(menu);
	}

	@Override
	public Menu find(Long id) throws MenuNotFoundException{

		Menu menu = menuRepository.findById(id).orElseThrow(
				() -> new MenuNotFoundException("Menu not found with id: " + id ));
		return menu;
	}
	
}
