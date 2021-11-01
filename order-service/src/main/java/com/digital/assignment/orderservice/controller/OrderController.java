package com.digital.assignment.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.assignment.orderservice.entity.Order;
import com.digital.assignment.orderservice.service.OrderService;

import dto.OrderDto;

/**
 * @author dtran@fortna.com
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order save(@RequestBody OrderDto orderDto) {
        return orderService.save(orderDto);
    }

    @GetMapping("/{orderId}")
    public Order getOrder(
        @PathVariable(value = "orderId") long orderId) {
            return orderService.getById(orderId);
    }

    @PostMapping("/{orderId}/status")
    public void updateOrderStatus(@PathVariable(value = "orderId") long orderId, @RequestBody String status) {
        orderService.updateOrderStatus(orderId, status);
    }


}
