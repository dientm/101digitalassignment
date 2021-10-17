package com.digital.assignment.shopservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital.assignment.shopservice.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
