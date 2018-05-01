package com.rest.practice.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Drink extends MenuItem{
	
	private boolean alcohol;
	
	public Drink() {}
		
	public boolean isAlcohol() {
		return alcohol;
	}

	public void setAlcohol(boolean alcohol) {
		this.alcohol = alcohol;
	}
}
