package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.BookCategory;


@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer>{
}