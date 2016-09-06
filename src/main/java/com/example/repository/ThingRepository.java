package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.models.Things;


public interface ThingRepository extends CrudRepository<Things, Long> {
	  public List<Things> findAllByOrderByIdAsc();
}
