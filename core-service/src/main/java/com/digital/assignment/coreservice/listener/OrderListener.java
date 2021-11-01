package com.digital.assignment.orderservice.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {
    @JmsListener(destination = "ORDER.NEW_ORDER", containerFactory = "defautFactory")
    public void receiveMessage(String shopId) {
        System.out.println(shopId);
    }
}
