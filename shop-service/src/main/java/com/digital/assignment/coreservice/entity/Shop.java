package com.digital.assignment.coreservice.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private String location;

    private String contact;

    private int queueSize;

    private int maxQueueSize;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
        name = "shop_product",
        joinColumns = {@JoinColumn(name = "shop_id")},
        inverseJoinColumns = {@JoinColumn(name = "product_id")}
    )
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy="shop", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<Queue> queues;

    public Long getId() {
        return id;
    }

    public Shop setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Shop setName(String name) {
        this.name = name;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Shop setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getContact() {
        return contact;
    }

    public Shop setContact(String contact) {
        this.contact = contact;
        return this;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public Shop setQueueSize(int queueSize) {
        this.queueSize = queueSize;
        return this;
    }

    public int getMaxQueueSize() {
        return maxQueueSize;
    }

    public Shop setMaxQueueSize(int maxQueueSize) {
        this.maxQueueSize = maxQueueSize;
        return this;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Shop setProducts(List<Product> products) {
        this.products = products;
        return this;
    }

    public Collection<Queue> getQueues() {
        return queues;
    }

    public Shop setQueues(Collection<Queue> queues) {
        this.queues = queues;
        return this;
    }
}
