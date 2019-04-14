package com.rest.practice.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("4")
public class Drink extends MenuItem{
	
	private boolean alcohol;
	
	public Drink() {}
		
	public Drink(String name, double price, String description, String secret, boolean alcohol) {
		super(name, price, description, secret);
		this.alcohol = alcohol;
	}
	
	public boolean isAlcohol() {
		return alcohol;
	}

	public void setAlcohol(boolean alcohol) {
		this.alcohol = alcohol;
	}

	@Override
	public int compareTo(MenuItem o) {
		return 0;
	}
}
