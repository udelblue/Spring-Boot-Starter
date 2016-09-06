package com.example.services;


import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Person;
import com.example.repository.IPeopleRepository;



@Service
@Transactional
public class PeopleService {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	
	IPeopleRepository pr;
	
	@Autowired
	public PeopleService(IPeopleRepository pr) {
		super();
		this.pr = pr;
		logger.info("--Person Service Created");
	}

	
	

	public List<Person> people(){
		return pr.people();
	}
	
	
	public List<Person> people(Person person){
		pr.addPerson(person);
		return people();
	}
	
	
}
