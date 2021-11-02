package com.digital.assignment.orderservice.exception;

import javassist.NotFoundException;

public class OrderNotFoundException extends NotFoundException {
    public OrderNotFoundException(long id) {
        super("order not found: " + id);
    }
}
