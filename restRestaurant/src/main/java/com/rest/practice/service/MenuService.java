package com.rest.practice.service;

import org.springframework.http.ResponseEntity;

import com.rest.practice.models.Menu;

public interface MenuService {

	void save(Menu menu);

	Menu find(long id);

}
