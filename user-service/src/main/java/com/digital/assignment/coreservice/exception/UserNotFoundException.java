package com.digital.assignment.coreservice.exception;

import javassist.NotFoundException;

/**
 * @author dtran@fortna.com
 */
public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(Long id) {
        super("Could not find user:  " + id);
    }

}
