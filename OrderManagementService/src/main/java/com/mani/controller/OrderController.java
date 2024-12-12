package com.mani.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mani.config.ProductServiceClient;
import com.mani.config.UserServiceClient;
import com.mani.entity.Order;
import com.mani.service.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductServiceClient productServiceClient;

    @Autowired
    private UserServiceClient customerServiceClient;

    // Create a new order
    @PostMapping("/create")
    public String createOrder(@ModelAttribute Order order, Model model) {
        String response = orderService.createOrder(order);
        model.addAttribute("response", response);
        return "orderForm"; // Return the view with the response message
    }

    // Display all orders
    @GetMapping("/all")
    public String getAllOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "ordersList"; // View to list all orders
    }

    // Fetch product details using Feign client
    @GetMapping("/product/{id}")
    public String getProductById(@PathVariable Long id, Model model) {
        String productDetails = productServiceClient.getProductById(id);
        model.addAttribute("product", productDetails);
        return "productDetails"; // Display product details page
    }

    // Fetch customer details using Feign client
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
		String userDetails = customerServiceClient.getUserById(id);
        model.addAttribute("user", userDetails);
        return "userDetails"; // Display customer details page
    }
}
