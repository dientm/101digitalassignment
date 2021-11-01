package com.digital.assignment.orderservice.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.digital.assignment.orderservice.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(
        value = "UPDATE orders  SET status = ?2 WHERE id = ?1",
        nativeQuery = true
    )
    int  updateStatus(long orderId, String status);
}
