package com.digital.assignment.shopservice.exception;

public class ShopNotFoundException extends RuntimeException {
    public ShopNotFoundException(Long id) {
        super("Could not find shop " + id);
    }
}
