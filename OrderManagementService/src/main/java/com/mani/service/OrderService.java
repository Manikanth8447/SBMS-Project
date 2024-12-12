package com.mani.service;

import java.util.List;

import com.mani.entity.Order;

public interface OrderService {
    String createOrder(Order order);
    
    Order getOrderById(Long id);
    
    List<Order> getAllOrders();
    
    String updateOrder(Long id, Order order);
    
    String deleteOrderById(Long id);
}
