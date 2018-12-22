package com.rest.practice.repository;

import org.springframework.data.repository.CrudRepository;

import com.rest.practice.models.Menu;

public interface MenuRepository extends CrudRepository<Menu, Long>{

	Menu findMenuById(long menuId);

}
