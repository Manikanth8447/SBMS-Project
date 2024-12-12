package com.mani.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mani.config.ProductServiceClient;
import com.mani.config.UserServiceClient;
import com.mani.entity.Order;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductServiceClient productServiceClient;

    @Autowired
    private UserServiceClient customerServiceClient;

    @Override
    public String createOrder(Order order) {
        // Fetching product details using Feign client
        String productDetails = productServiceClient.getProductById(order.getProductId());

        // Fetching customer details using Feign client
        String customerDetails = customerServiceClient.getUserById(order.getCustomerId());

        // Check if product and customer details are valid
        if (productDetails != null && customerDetails != null) {
            // Create the order (here, assuming that Order saving is done separately, e.g., via JPA repository)
            return "Order created for Product: " + productDetails + " and Customer: " + customerDetails;
        }
        return "Failed to create order due to missing product or customer information.";
    }

    @Override
    public Order getOrderById(Long id) {
        // Simulating fetching the order from database (e.g., using JPA repository)
        return new Order(id, 1L, 1L, "Created", LocalDateTime.now());
    }

    @Override
    public List<Order> getAllOrders() {
        // Example: Returning a hardcoded list of orders
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1L, 1L, 1L, "Created", LocalDateTime.of(2024, 12, 12, 10, 0, 0)));
        orders.add(new Order(2L, 2L, 1L, "Shipped", LocalDateTime.of(2024, 12, 15, 14, 30, 0)));
        return orders;
    }

    @Override
    public String updateOrder(Long id, Order order) {
        // Logic to update order
        return "Order with ID " + id + " updated successfully.";
    }

    @Override
    public String deleteOrderById(Long id) {
        // Logic to delete order
        return "Order with ID " + id + " deleted successfully.";
    }
}
