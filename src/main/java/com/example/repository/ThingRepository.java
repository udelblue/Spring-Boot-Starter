package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Things;


public interface ThingRepository extends JpaRepository<Things, Long> {
	  public List<Things> findAllByOrderByIdAsc();
}
