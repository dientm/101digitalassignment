package dto;

import java.util.List;

import lombok.Data;


public class QueueDto {
    private long id;
    private List<WorkingQueueDto> workingQueues;

    public long getId() {
        return id;
    }

    public QueueDto setId(long id) {
        this.id = id;
        return this;
    }

    public List<WorkingQueueDto> getWorkingQueues() {
        return workingQueues;
    }

    public QueueDto setWorkingQueues(List<WorkingQueueDto> workingQueues) {
        this.workingQueues = workingQueues;
        return this;
    }
}
