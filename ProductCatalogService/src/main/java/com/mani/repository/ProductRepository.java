package com.mani.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mani.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
