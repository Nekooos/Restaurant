package com.rest.practice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class MenuItem {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private long id;
	@NotNull
	private String name;
	@NotNull
	private double price;
	@NotNull
	private String description;
	
	@JsonIgnore
	@Column(name="secret_ingredient")
	private String secretIngredient;
	
	public MenuItem() {
		
	}
	
	public MenuItem(String name, double price, String description, String secret) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.secretIngredient = secret;
	}
	
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSecretIngredient() {
		return secretIngredient;
	}

	public void setSecretIngredient(String secretIngredient) {
		this.secretIngredient = secretIngredient;
	}
	public MenuItem(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
