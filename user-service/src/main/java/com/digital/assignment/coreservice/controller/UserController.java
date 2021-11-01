package com.digital.assignment.coreservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.assignment.coreservice.entity.User;
import com.digital.assignment.coreservice.service.UserService;

import dto.UserDto;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User save(@RequestBody UserDto user) {
        return userService.save(user);
    }

    @GetMapping("/{userId}")
    public User getUser(
        @PathVariable(value = "userId") long userId) {
            return userService.getById(userId);
    }


}
