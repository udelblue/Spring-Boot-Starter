package com.example.services.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.example.models.security.User;
import com.example.repository.security.UserRepository;

public class UserService {

	@Autowired
	UserRepository ur;
	
	
	public List<User> GetAllUsers(){
		return ur.findAll();
	}
	
	public User GetUserByName(String username){
		return ur.findByUsername(username);
	}

	
	public User GetUserByID(Long id){
		return ur.findOne(id);
	}
	
	
	public Page<User> GetAllUsers(Pageable pageable){
		Page<User> users = ur.findAll(pageable);
		return users;
	}
	
	public Page<User> GetAllUsers(int page , int size){
		Page<User> users = ur.findAll(new PageRequest(page, size));
		return users;
	}
	

	
	
	
}
