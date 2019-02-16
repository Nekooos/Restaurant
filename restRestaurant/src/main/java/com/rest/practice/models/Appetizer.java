package com.rest.practice.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Appetizer extends MenuItem{
	public Appetizer() {}
	
	public Appetizer(String name, double price, String description, String secret) {
		super(name, price, description, secret);
	}

	@Override
	public int compareTo(MenuItem o) {
		return 0;
	}
}
