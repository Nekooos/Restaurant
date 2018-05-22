package com.rest.practice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.practice.models.MenuItem;
import com.rest.practice.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@GetMapping("/all")
    public List<MenuItem> getMenu() {
		return menuService.findAll();
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<MenuItem> getMenuItem(@PathVariable ("id")Long id) {
		MenuItem menuItem = menuService.find(id);
		return ResponseEntity.status(200).body(menuItem);
    }
	
	@PostMapping("/save")
	public ResponseEntity<MenuItem> saveMenuItem(@RequestBody MenuItem menuItem) {
		 menuService.save(menuItem);
		 return ResponseEntity.status(201).body(menuItem);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<MenuItem> editMenuItem(@PathVariable("id")long id, @RequestBody MenuItem menuItem) {
		 menuItem = menuService.edit(id, menuItem);
		 return ResponseEntity.status(200).body(menuItem);
	}

	@PutMapping("/delete/{id}")
	public ResponseEntity<?> deleteMenuItem(@PathVariable ("id")long id) {
		 menuService.delete(id);
		 return ResponseEntity.status(200).body("Menu item was deleted succesfully");
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
