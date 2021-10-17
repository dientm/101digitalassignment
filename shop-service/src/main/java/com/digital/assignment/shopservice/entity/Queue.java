package com.digital.assignment.shopservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.yahoo.elide.annotation.Include;
import com.yahoo.elide.graphql.subscriptions.annotations.SubscriptionField;


@Include(rootLevel = false, name = "queues")
@Entity
public class Queue {
    @Id
    @GeneratedValue
    private Long id;

    @SubscriptionField
    private int maxNumber;

    @ManyToOne
    private Shop shop = null;

}
