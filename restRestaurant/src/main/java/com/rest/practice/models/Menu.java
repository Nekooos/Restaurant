package com.rest.practice.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "menu_name")
	private String menuName;
	
	@ManyToOne
	private Restaurant restaurant;

	@OneToMany
	private List<MenuItem> menuItems;
	
	public Menu() {}
	
	public Menu(String menuName, Restaurant restaurant, List<MenuItem> menuItems) {
		this.menuName = menuName;
		this.restaurant = restaurant;
		this.menuItems = menuItems;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<MenuItem> getMenuitems() {
		return menuItems;
	}

	public void setMenuitems(List<MenuItem> menuitems) {
		this.menuItems = menuitems;
	}
	
}
