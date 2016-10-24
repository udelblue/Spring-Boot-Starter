package com.example;


import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.models.security.User;
import com.example.services.security.UserService;

@SpringBootApplication
public class StarterApplication {

	private static final Logger logger = Logger.getLogger(StarterApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(StarterApplication.class, args);
	}
	

	
	
	@PostConstruct
	public void postrun() 
	{
		
		//logger.info("---Application Started---");
		
		
	}
	
	

	
}
