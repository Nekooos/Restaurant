package com.rest.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication(scanBasePackages = {"com.rest.practice"})
public class RestRestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestRestaurantApplication.class, args);
	}
}


/*
{
	"username" : "user",
	"password" : "pass",
	"firstName" : "Mirre",
	"lastName" : "Mullvad",
	"roles" : ["ROLE_ADMIN"]
}

*/