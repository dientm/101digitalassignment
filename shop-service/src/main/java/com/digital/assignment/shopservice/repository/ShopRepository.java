package com.digital.assignment.shopservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital.assignment.shopservice.entity.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
}
