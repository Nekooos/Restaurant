package com.rest.practice.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class MainCourse extends MenuItem{
	public MainCourse() {
		super();
	}
}
