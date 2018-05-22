package com.rest.practice.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Kramer
 *
 */
/**
 * @author Kramer
 *
 */
@Entity
@DiscriminatorValue("2")
public class MainCourse extends MenuItem{
	public MainCourse() {}
	
	public MainCourse(String name, double price, String description, String secret) {
		super(name, price, description, secret);
	}
}
