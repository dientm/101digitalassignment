package com.digital.assignment.shopservice;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data    
@Component
public class SecurityConfigProperties {    
    private String origin = "*";
}