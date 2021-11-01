package com.digital.assignment.coreservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.assignment.coreservice.entity.WorkingQueue;
import com.digital.assignment.coreservice.service.QueueService;

import dto.WorkingQueueDto;

@RestController
@RequestMapping(value = "/queues")
public class QueueController {

    @Autowired
    private QueueService queueService;


    @PostMapping(value = "working-queue")
    public WorkingQueue createWorkingQueue(@RequestBody WorkingQueueDto workingQueueDto) {
        return queueService.creteWorkingQueue(workingQueueDto);
    }
    

}
