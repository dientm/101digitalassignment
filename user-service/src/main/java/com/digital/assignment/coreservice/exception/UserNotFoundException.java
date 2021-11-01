package com.digital.assignment.coreservice.exception;

import javassist.NotFoundException;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(Long id) {
        super("Could not find user:  " + id);
    }

}
