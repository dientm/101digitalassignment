package com.digital.assignment.coreservice.exception;

import javassist.NotFoundException;

public class ShopNotFoundException extends NotFoundException {
    public ShopNotFoundException(Long id) {
        super("Could not find shop " + id);
    }
}
