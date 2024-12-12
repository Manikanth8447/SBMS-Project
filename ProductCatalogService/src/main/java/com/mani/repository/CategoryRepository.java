package com.mani.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mani.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
