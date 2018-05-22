package com.rest.practice.config;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityUtility {
	private static final String SALT = "salt"; // Replace later
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
	}
	
	/**
	 * Pick 18 at random from SALTCHARS
	 * @return String
	 */
	@Bean
	public static String randomPassword() {
		String SALTCHARS ="ABCDEFGHIJKLMNOPQRSTUVXYZ123456789";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		
		while(salt.length() < 18) {
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}
}
