package com.example.services.security;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.models.security.User;
import com.example.repository.security.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository ur;
	
	
	public User AddUser(User user){
		return ur.save(user);
	}
	
	
	public List<User> GetAllUsers(){
		return ur.findAll();
	}
	
	
	public User UpdateUser(User user){
		ur.save(user);
		
		return ur.findOne(user.getId());
	}
	
	
	public User GetUserByName(String username){
		return ur.findByUsername(username);
	}

	
	public User GetUserByID(int i){
		return ur.findOne((long) i);
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
