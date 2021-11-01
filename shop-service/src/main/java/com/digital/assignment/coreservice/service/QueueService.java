package com.digital.assignment.coreservice.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.assignment.coreservice.entity.Queue;
import com.digital.assignment.coreservice.entity.WorkingQueue;
import com.digital.assignment.coreservice.helper.Transformer;
import com.digital.assignment.coreservice.repository.QueueRepository;
import com.digital.assignment.coreservice.repository.WorkingQueueRepository;

import dto.WorkingQueueDto;

@Service
public class QueueService {

    @Autowired
    private QueueRepository queueRepository;

    @Autowired
    WorkingQueueRepository workingQueueRepository;


    public List<Queue> getByIds(Collection<Long> ids) {
        return queueRepository.findAllById(ids);
    }

    public WorkingQueue creteWorkingQueue(WorkingQueueDto workingQueueDto) {
        Queue queue = queueRepository.findById(workingQueueDto.getQueueId()).get();
        WorkingQueue workingQueue = Transformer.transform(workingQueueDto);
        workingQueue.setQueue(queue);
        return workingQueueRepository.saveAndFlush(workingQueue);

    }
}
