package com.mani.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mani.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
