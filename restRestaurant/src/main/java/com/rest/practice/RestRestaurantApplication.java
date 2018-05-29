package com.rest.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.rest.practice.models.User;
import com.rest.practice.service.UserService;
import com.rest.practice.service.UserServiceImpl;

@SpringBootApplication(scanBasePackages = {"com.rest.practice"})
public class RestRestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestRestaurantApplication.class, args);
	}
}

//$2a$10$mqnKebQBkt9VTwLyqAYK1OclLdkja7hcdjqTI4IKii3G7bL15b5Pa pass