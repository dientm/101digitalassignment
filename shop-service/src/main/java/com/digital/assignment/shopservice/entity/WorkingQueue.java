package com.digital.assignment.shopservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class WorkingQueue {
    @Id
    @GeneratedValue
    private Long id;

}
