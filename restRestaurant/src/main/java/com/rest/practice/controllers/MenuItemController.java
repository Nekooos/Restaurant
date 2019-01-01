package com.rest.practice.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import com.rest.practice.Exception.InternalServerErrorException;
import com.rest.practice.Exception.MenuItemNotFoundException;
import com.rest.practice.Exception.MenuNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.practice.models.MenuItem;
import com.rest.practice.service.MenuItemService;

@RestController
@RequestMapping("/item")
public class MenuItemController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MenuItemService menuItemService;
	
	@GetMapping("/all")
    public ResponseEntity<List<MenuItem>> getMenu() {
		List<MenuItem> menuItems = menuItemService.findAll();
		return ResponseEntity.status(200).body(menuItems);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<MenuItem> getMenuItem(@PathVariable ("id")Long id) {
		MenuItem menuItem;
		try {
			menuItem = menuItemService.find(id);

		} catch(MenuItemNotFoundException e) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.status(200).body(menuItem);
    }
	
	@PostMapping("/save")
	public ResponseEntity<MenuItem> saveMenuItem(@RequestBody MenuItem menuItem) {
		 menuItemService.save(menuItem);
		 return ResponseEntity.status(201).body(menuItem);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<MenuItem> editMenuItem(@PathParam("id")long id, @RequestBody MenuItem menuItem) {
		try {
			menuItem = menuItemService.edit(id, menuItem);
		} catch(MenuItemNotFoundException e) {
			return ResponseEntity.status(404).build();
		} catch(InternalServerErrorException e) {
			return ResponseEntity.status(500).build();
		}
		return ResponseEntity.status(200).body(menuItem);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteMenuItem(@PathVariable ("id")long id) {
		try {
			menuItemService.delete(id);
		} catch (Exception e) {
			return ResponseEntity.status(500).build();
		}
		return ResponseEntity.status(200).body("Menu item was deleted succesfully");
	}
	
	@PostMapping("/add{item_id}")
	public ResponseEntity<?> addMenuItem(@PathParam("item_id") @RequestBody MenuItem menuItem) {
		try {
			menuItemService.save(menuItem);
		} catch (Exception e) {
			//todo find exceptions
			logger.debug("internal server error" + e.getMessage());
			return ResponseEntity.status(500).build();
		}
		return ResponseEntity.status(200).body(menuItem);
	}
	 
	/*
	 * public ResponseEntity<?> method() {
    boolean b = // some logic
    if (b)
        return new ResponseEntity<Success>(HttpStatus.OK);
    else
        return new ResponseEntity<Error>(HttpStatus.CONFLICT); //appropriate error code
}
	 */
}
