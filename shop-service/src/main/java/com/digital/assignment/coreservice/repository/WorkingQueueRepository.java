package com.digital.assignment.coreservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital.assignment.coreservice.entity.Queue;
import com.digital.assignment.coreservice.entity.WorkingQueue;

@Repository
public interface WorkingQueueRepository extends JpaRepository<WorkingQueue, Long> {
}
