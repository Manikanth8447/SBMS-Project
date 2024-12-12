package com.mani.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")  // Service name in Eureka or Config Server
public interface UserServiceClient {

    @GetMapping("/user/{id}")
    String getUserById(@PathVariable("id") Long userId); // Assuming it returns user details as a String
}
