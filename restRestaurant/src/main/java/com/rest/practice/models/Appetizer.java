package com.rest.practice.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Appetizer extends MenuItem{
	public Appetizer() {
		super();
	}
	
	public Appetizer(String name, double price, String description) {
		super();
	}
}
