package com.example.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.springframework.beans.factory.annotation.Autowired;


import com.example.repository.ThingRepository;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@Entity
@Table(name="ADDRESS")
@Audited
@AuditTable(value="__ADDRESS_AUD")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY,isGetterVisibility = JsonAutoDetect.Visibility.ANY,getterVisibility = JsonAutoDetect.Visibility.ANY)
public class Address {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String streetname;

    private int housenumber;

    
    private int flatnumber;
    
    
   // @OneToMany(mappedBy = "bookCategory", cascade = CascadeType.ALL)
  //  private Set<Book> books;

	@OneToMany(mappedBy = "address" , cascade= CascadeType.ALL, fetch = FetchType.EAGER, targetEntity =Person.class)
    private Set<Person> persons = new HashSet<Person>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	public String getStreetname() {
		return streetname;
	}

	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}

	public int getHousenumber() {
		return housenumber;
	}

	public void setHousenumber(int housenumber) {
		this.housenumber = housenumber;
	}

	public int getFlatnumber() {
		return flatnumber;
	}

	public void setFlatnumber(int flatnumber) {
		this.flatnumber = flatnumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + flatnumber;
		result = prime * result + housenumber;
		result = prime * result + id;
		result = prime * result
				+ ((streetname == null) ? 0 : streetname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (flatnumber != other.flatnumber)
			return false;
		if (housenumber != other.housenumber)
			return false;
		if (id != other.id)
			return false;
		if (streetname == null) {
			if (other.streetname != null)
				return false;
		} else if (!streetname.equals(other.streetname))
			return false;
		return true;
	}

	
    
}