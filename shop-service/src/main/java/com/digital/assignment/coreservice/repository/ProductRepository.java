package com.digital.assignment.coreservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital.assignment.coreservice.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
