package com.digital.assignment.coreservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital.assignment.coreservice.entity.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
}
