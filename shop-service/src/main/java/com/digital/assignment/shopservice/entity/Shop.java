package com.digital.assignment.shopservice.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.yahoo.elide.annotation.Include;
import com.yahoo.elide.graphql.subscriptions.annotations.Subscription;
import com.yahoo.elide.graphql.subscriptions.annotations.SubscriptionField;

import lombok.Data;

@Include(name = "shops")
@Entity
@Subscription
@Data
public class Shop {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @SubscriptionField
    private String name;

    @SubscriptionField
    private String location;

    @SubscriptionField
    private String contact;

    @SubscriptionField
    private int queueSize;

    @SubscriptionField
    private int maxQueueSize;

    @ManyToMany(fetch = FetchType.EAGER)
    @SubscriptionField
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy="shop")
    private List<Queue> queues = new ArrayList<>();

}
