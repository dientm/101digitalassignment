package com.digital.assignment.coreservice.service;

import java.util.Comparator;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dto.OrderDto;
import dto.QueueDto;
import dto.ShopDto;
import dto.WorkingQueueDto;

@Service
public class CoreService {

    private final RestTemplate restTemplate;

    private final JmsTemplate jmsTemplate;

    public CoreService(RestTemplate restTemplate, JmsTemplate jmsTemplate) {
        this.restTemplate = restTemplate;
        this.jmsTemplate = jmsTemplate;
    }

    // TODO: need to synchronize this logic
    public void processOrder(long orderId) {
        OrderDto order = restTemplate.getForObject("http://order-service/orders/" + orderId, OrderDto.class);
        long shopId = order.getShopId();

        ShopDto shop = restTemplate.getForObject("http://shop-service/shops/" + shopId, ShopDto.class);
        long availableQueue = shop.getQueues()
            .stream()
            .filter(q -> q.getWorkingQueues().size() >= shop.getMaxQueueSize()).count();

        if (availableQueue < 1) {
            // no queue available
            return;
        }
        QueueDto selectedQueue = shop.getQueues()
            .stream()
            .min(Comparator.comparing(q -> q.getWorkingQueues().size())).get();

        // calculate waiting time

        // put to selected queue
        WorkingQueueDto workingQueueDto = new WorkingQueueDto();
        workingQueueDto.setQueueId(selectedQueue.getId());
        workingQueueDto.setOrderId(order.getId());
        workingQueueDto.setStatus("QUEUED");
        workingQueueDto.setEstimateInSec(300);
        restTemplate.postForObject("http://shop-service/queues/working-queue", workingQueueDto, WorkingQueueDto.class);

        // update order status to QUEUED
        restTemplate.postForObject("http://order-service/orders/" + orderId + "/status", "QUEUED", String.class);



    }
}
