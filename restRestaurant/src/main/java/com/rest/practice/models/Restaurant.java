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
	
	private String about;
	 
	@Column(name = "phone_number")
	private int phoneNumber;
	
	private String adress;
	
	@OneToMany()
	private List<Menu> menu;
	
	public Restaurant() {}
	
	public Restaurant(String restaurantName, String about, int phoneNumber, String adress, List<Menu> menu) {
		this.restaurantName = restaurantName;
		this.about = about;
		this.phoneNumber = phoneNumber;
		this.adress = adress;
		this.menu = menu;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}
	
	
}
