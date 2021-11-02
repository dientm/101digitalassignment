package com.digital.assignment.coreservice.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.digital.assignment.coreservice.service.CoreService;

import dto.ordering.Ordering;

@Component
public class OrderListener {

    @Autowired
    CoreService coreService;

    @JmsListener(destination = "ORDER.NEW_ORDER", containerFactory = "defautFactory")
    public void receiveMessage(Ordering ordering) {
        
        coreService.processOrder(ordering.getOrderId());
    }
}
