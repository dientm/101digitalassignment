package com.digital.assignment.coreservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.assignment.coreservice.service.CoreService;

import dto.ordering.Ordering;

@RestController
@RequestMapping("/ordering")
public class OrderingController {

    @Autowired
    private CoreService coreService;

    @PostMapping
    public void ordering(@RequestBody Ordering ordering) {
        coreService.processOrder(ordering.getOrderId());
    }
}
