package com.digital.assignment.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.digital.assignment.orderservice.entity.Order;
import com.digital.assignment.orderservice.exception.OrderNotFoundException;
import com.digital.assignment.orderservice.service.OrderService;

import dto.OrderDto;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody OrderDto orderDto) throws Exception {
        return orderService.save(orderDto);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable(value = "orderId") long orderId) throws OrderNotFoundException {
            return ResponseEntity.ok(orderService.getById(orderId));
    }

    @PostMapping("/{orderId}/status")
    public void updateOrderStatus(@PathVariable(value = "orderId") long orderId, @RequestBody String status) {
        orderService.updateOrderStatus(orderId, status);
    }


}
