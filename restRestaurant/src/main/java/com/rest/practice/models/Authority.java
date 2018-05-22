package com.rest.practice.models;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority, Serializable{
	//Serializable passed around in transaktions
	private static final long serialVersionUID = -491485128128013467L;
	
	private final String authority;
	
	public Authority(String authority) {
		this.authority = authority;
	}
	
	@Override
	public String getAuthority() {
		
		return authority;
	}

}
