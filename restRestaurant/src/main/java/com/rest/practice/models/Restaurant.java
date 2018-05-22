package com.rest.practice.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "restaurant_name")
	private String restaurantName;
	
	@Column(name = "about", length=10000)
	private String about;
	
	@OneToMany
	private List<Menu> menu;
	
}
