package com.mani.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service") // Service name in Eureka or Config Server
public interface ProductServiceClient {

	@GetMapping("/products/{id}")
	String getProductById(@PathVariable("id") Long productId); // Assuming it returns product details as a String
}
