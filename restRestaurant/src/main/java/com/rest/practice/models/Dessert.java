package com.rest.practice.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("3")
public class Dessert extends MenuItem{
	public Dessert() {}
	
	public Dessert(String name, double price, String description, String secret) {
		super(name, price, description, secret);
	}
}

