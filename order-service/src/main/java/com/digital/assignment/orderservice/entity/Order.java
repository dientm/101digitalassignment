package com.digital.assignment.orderservice.entity;


import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Table(name = "orders")
@Entity
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    private Long shopId;

    private String status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Collection<OrderItem> items;

}
