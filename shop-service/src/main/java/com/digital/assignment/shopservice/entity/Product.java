package com.digital.assignment.shopservice.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.yahoo.elide.annotation.Include;
import com.yahoo.elide.graphql.subscriptions.annotations.SubscriptionField;

@Include(rootLevel = false, name = "products")
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @SubscriptionField
    private String name;

    @SubscriptionField
    private double price;

    @ManyToMany(mappedBy = "products")
    @SubscriptionField
    private List<Shop> shops = new ArrayList<>();

}
