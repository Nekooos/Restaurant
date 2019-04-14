package com.rest.practice.controllers;

import javax.websocket.server.PathParam;

import com.rest.practice.Exception.MenuItemNotFoundException;
import com.rest.practice.Exception.MenuNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.practice.models.Menu;
import com.rest.practice.service.MenuItemService;
import com.rest.practice.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private MenuItemService menuItemService;
	
	@PostMapping("/save")
	public ResponseEntity<Menu> saveMenu(Menu menu) {
		menuService.save(menu);
		return ResponseEntity.status(201).body(menu);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Menu> findById(@PathParam("id") long id) {
		Menu menu;
		try {
			menu = menuService.find(id);
			return ResponseEntity.status(200).body(menu);
		} catch(MenuNotFoundException e) {
			return ResponseEntity.status(404).build();
		}
	}
}
