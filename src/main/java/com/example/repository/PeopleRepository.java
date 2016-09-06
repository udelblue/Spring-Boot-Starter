package com.example.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.models.Person;


@Repository
@Transactional
public class PeopleRepository implements IPeopleRepository{

	
	

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Person> people(){

		Session session = sessionFactory.openSession();
		 List<Person> P =  session.createQuery("FROM Person").list();
	
		return P;
	}
	
	@Transactional
	public List<Person> addPerson(Person person){
		

	
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.saveOrUpdate(person);

		session.getTransaction().commit();
		

		return this.people();
	}
	
	
	

}
