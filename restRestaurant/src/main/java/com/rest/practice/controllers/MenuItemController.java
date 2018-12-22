package com.rest.practice.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

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

	@Autowired
	private MenuItemService menuItemService;
	
	@GetMapping("/all")
    public List<MenuItem> getMenu() {
		return menuItemService.findAll();
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<MenuItem> getMenuItem(@PathVariable ("id")Long id) {
		MenuItem menuItem = menuItemService.find(id);
		return ResponseEntity.status(200).body(menuItem);
    }
	
	@PostMapping("/save")
	public ResponseEntity<MenuItem> saveMenuItem(@RequestBody MenuItem menuItem) {
		 menuItemService.save(menuItem);
		 return ResponseEntity.status(201).body(menuItem);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<MenuItem> editMenuItem(@PathParam("id")long id, @RequestBody MenuItem menuItem) {
		 menuItem = menuItemService.edit(id, menuItem);
		 return ResponseEntity.status(200).body(menuItem);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteMenuItem(@PathVariable ("id")long id) {
		 menuItemService.delete(id);
		 return ResponseEntity.status(200).body("Menu item was deleted succesfully");
	}
	
	@PostMapping("add{item_id}/menu{menu_id}")
	public void addMenuItemToMenu(@PathParam("item_id") long itemId,
								  @PathParam("menu_id") long menuId) {
		menuItemService.add(itemId, menuId);
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
