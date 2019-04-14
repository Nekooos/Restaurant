package com.rest.practice.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("2")
public class MainCourse extends MenuItem {
	public MainCourse() {}
	
	public MainCourse(String name, double price, String description, String secret) {
		super(name, price, description, secret);
	}

	@Override
	public int compareTo(MenuItem o) {
		return 0;
	}
}
