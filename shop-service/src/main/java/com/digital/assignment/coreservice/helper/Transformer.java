package com.digital.assignment.coreservice.helper;

import java.util.Optional;
import java.util.stream.Collectors;

import com.digital.assignment.coreservice.entity.Product;
import com.digital.assignment.coreservice.entity.Queue;
import com.digital.assignment.coreservice.entity.Shop;
import com.digital.assignment.coreservice.entity.WorkingQueue;

import dto.QueueDto;
import dto.ShopDto;
import dto.WorkingQueueDto;

public final class Transformer {

    public static ShopDto transform(Shop shop) {
        return Optional.ofNullable(shop)
            .map(map -> new ShopDto().setId(shop.getId())
                .setContact(shop.getContact())
                .setLocation(shop.getLocation())
                .setOpenHour(shop.getOpenHour())
                .setCloseHour(shop.getCloseHour())
                .setProducts(shop.getProducts().stream().map(Product::getId).collect(Collectors.toList()))
                .setQueueSize(shop.getQueueSize())
                .setMaxQueueSize(shop.getMaxQueueSize())
                .setQueues(shop.getQueues().stream().map(Transformer::transform).collect(Collectors.toList()))
            ).get();
    }

    public static QueueDto transform(Queue queue) {
        return Optional.ofNullable(queue)
            .map(map -> new QueueDto()
                .setId(queue.getId())
                .setWorkingQueues(queue.getWorkingQueues().stream().map(Transformer::transform).collect(Collectors.toList()))
            ).get();

    }

    public static WorkingQueueDto transform(WorkingQueue workingQueue) {
        return Optional.ofNullable(workingQueue)
            .map(map -> new WorkingQueueDto()
                .setOrderId(workingQueue.getOrderId())
                .setStatus(workingQueue.getStatus())
                .setEstimateInSec(workingQueue.getEstimateTime())
                .setQueueId(workingQueue.getQueue().getId()))
            .get();
    }

    public static WorkingQueue transform(WorkingQueueDto dto) {
        return Optional.ofNullable(dto)
            .map(map -> new WorkingQueue()
                .setOrderId(dto.getOrderId())
                .setEstimateTime(dto.getEstimateInSec())
                .setStatus(dto.getStatus())
            ).get();
    }
}
