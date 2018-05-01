package com.rest.practice.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne
	private Restaurant restaurant;
	
	@OneToMany
	private List<Drink> drinks;
	
	@OneToMany
	private List<Dessert> desserts;
	
	@OneToMany
	private List<MainCourse> mainCourse;
	
	@OneToMany
	private List<Appetizer> appetizers;
}
