package com.example.mocks;

import java.util.ArrayList;
import java.util.List;

import com.example.models.Person;
import com.example.repository.IPeopleRepository;


public class MockPeopleRepository implements IPeopleRepository {

	
	private List<Person> people;

	public MockPeopleRepository() {
		super();
		this.people = new ArrayList<Person>();
		
		Person p1 = new Person();
		Person p2= new Person();
		Person p3= new Person();
		Person p4= new Person();
		people.add(p1);
		people.add(p2);
		people.add(p3);
		people.add(p4);
	}

	@Override
	public List<Person> people() {
		
		return this.people;
	}

	@Override
	public List<Person> addPerson(Person person) {
		this.people.add(person);
		
		return this.people;
	}



	
	
	
	
}
