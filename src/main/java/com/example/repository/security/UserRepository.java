package com.example.repository.security;

import org.springframework.data.jpa.repository.*;

import com.example.models.security.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
   
 
    
    
}