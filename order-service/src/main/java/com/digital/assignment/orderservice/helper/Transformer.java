package com.digital.assignment.orderservice.helper;

import java.util.Optional;

import com.digital.assignment.orderservice.entity.Order;

import dto.ordering.OrderDto;

public class Transformer {

    public static OrderDto transform(Order order) {
        return Optional.ofNullable(order)
            .map(map -> new OrderDto())
            .get();
    }
}
