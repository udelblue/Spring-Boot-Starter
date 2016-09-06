package com.example.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.security.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}