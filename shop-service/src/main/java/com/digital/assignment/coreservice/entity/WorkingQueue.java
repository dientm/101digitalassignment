package com.digital.assignment.coreservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
public class WorkingQueue {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "queue_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Queue queue;

    private long orderId;

    private int estimateTime;

    private String status;

    public Long getId() {
        return id;
    }

    public WorkingQueue setId(Long id) {
        this.id = id;
        return this;
    }

    public Queue getQueue() {
        return queue;
    }

    public WorkingQueue setQueue(Queue queue) {
        this.queue = queue;
        return this;
    }

    public long getOrderId() {
        return orderId;
    }

    public WorkingQueue setOrderId(long orderId) {
        this.orderId = orderId;
        return this;
    }

    public int getEstimateTime() {
        return estimateTime;
    }

    public WorkingQueue setEstimateTime(int estimateTime) {
        this.estimateTime = estimateTime;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public WorkingQueue setStatus(String status) {
        this.status = status;
        return this;
    }
}
