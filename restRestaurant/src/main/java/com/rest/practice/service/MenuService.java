package com.rest.practice.service;

import com.rest.practice.Exception.MenuNotFoundException;
import org.springframework.http.ResponseEntity;

import com.rest.practice.models.Menu;

import java.util.Optional;

public interface MenuService {

	void save(Menu menu);

	Menu find(Long id) throws MenuNotFoundException;

}
