package com.example;


import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StarterApplication {

	private static final Logger logger = Logger.getLogger(StarterApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(StarterApplication.class, args);
	}
	
	@PostConstruct
	public void postrun() 
	{
		
		logger.info("---Application Started---");
		
		
		
		
	}
	
	

	
}
