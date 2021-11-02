package com.digital.assignment.orderservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.digital.assignment.orderservice.entity.Order;
import com.digital.assignment.orderservice.entity.OrderItem;
import com.digital.assignment.orderservice.exception.OrderNotFoundException;
import com.digital.assignment.orderservice.repository.OrderRepository;

import constant.OrderStatus;
import constant.QueueNames;
import dto.OrderDto;
import dto.ordering.Ordering;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    private final RestTemplate restTemplate;

    private final JmsTemplate jmsTemplate;

    public OrderService(RestTemplate restTemplate, JmsTemplate jmsTemplate) {
        this.restTemplate = restTemplate;
        this.jmsTemplate = jmsTemplate;
    }

    public Order save(OrderDto orderDto) throws Exception {

        // final long shopId = orderDto.getShopId();
        // ShopDto shop = restTemplate.getForObject("http://shop-service/shops/" + shopId, ShopDto.class);

        Order order = new Order();
        order.setShopId(orderDto.getShopId());
        order.setUserId(orderDto.getUserId());
        List<OrderItem> orderItems = orderDto.getItems()
            .stream()
            .map(i -> {
                OrderItem orderItem = new OrderItem();
                orderItem.setProductId(i.getProductId());
                orderItem.setQty(i.getQty());
                orderItem.setOrder(order);

                return orderItem;
            }).collect(Collectors.toList());
        order.setItems(orderItems);
        order.setStatus(OrderStatus.PLACED);

        Order entity = orderRepository.saveAndFlush(order);

        // call core-service to notify the queue
        // TODO: using event-based or async request
        jmsTemplate.convertAndSend(QueueNames.QUEUE_NEW_ORDER, new Ordering(entity.getId()));
//        restTemplate.postForObject("http://core-service/ordering", new Ordering(entity.getId()), Ordering.class);

        return orderRepository.findById(entity.getId()).orElse(null);

    }

    public Order getById(long id) throws OrderNotFoundException {
        Order order = this.orderRepository.findById(id).orElse(null);
        if (order == null) {
            throw new OrderNotFoundException(id);
        }
        return order;
    }

    public void updateOrderStatus(long orderId, String status) {
        orderRepository.updateStatus(orderId, status);
    }
}
