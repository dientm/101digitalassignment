package com.digital.assignment.coreservice.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Entity
@Data
public class Queue {
    @Id
    @GeneratedValue
    private Long id;

    private int maxNumber;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Shop shop;

    @OneToMany(mappedBy = "queue", cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<WorkingQueue> workingQueues;

    public Long getId() {
        return id;
    }

    public Queue setId(Long id) {
        this.id = id;
        return this;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public Queue setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
        return this;
    }

    public Shop getShop() {
        return shop;
    }

    public Queue setShop(Shop shop) {
        this.shop = shop;
        return this;
    }

    public Collection<WorkingQueue> getWorkingQueues() {
        return workingQueues;
    }

    public Queue setWorkingQueues(Collection<WorkingQueue> workingQueues) {
        this.workingQueues = workingQueues;
        return this;
    }
}
