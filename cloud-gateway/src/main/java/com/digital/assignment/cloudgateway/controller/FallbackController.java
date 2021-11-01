package com.digital.assignment.cloudgateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/auth-fallback")
    public String authFallback() {
        return "Auth service is not available";
    }

    @GetMapping("/user-fallback")
    public String userFallback() {
        return "User service is not available";
    }

    @GetMapping("/shop-fallback")
    public String shopFallback() {
        return "Shop service is not available";
    }

}
