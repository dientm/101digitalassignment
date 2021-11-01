package com.digital.assignment.coreservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital.assignment.coreservice.entity.Queue;

@Repository
public interface QueueRepository extends JpaRepository<Queue, Long> {
}
