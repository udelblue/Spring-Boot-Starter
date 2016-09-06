package com.example.repository;

import java.util.List;

import com.example.models.Person;

public interface IPeopleRepository {

	 List<Person> people();
	 List<Person> addPerson(Person person);
	
	
}
