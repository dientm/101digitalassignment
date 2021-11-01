package dto;

public class WorkingQueueDto {
    private long id;
    private long queueId;
    private long orderId;
    private int estimateInSec;
    private String status;

    public long getId() {
        return id;
    }

    public WorkingQueueDto setId(long id) {
        this.id = id;
        return this;
    }

    public long getQueueId() {
        return queueId;
    }

    public WorkingQueueDto setQueueId(long queueId) {
        this.queueId = queueId;
        return this;
    }

    public long getOrderId() {
        return orderId;
    }

    public WorkingQueueDto setOrderId(long orderId) {
        this.orderId = orderId;
        return this;
    }

    public int getEstimateInSec() {
        return estimateInSec;
    }

    public WorkingQueueDto setEstimateInSec(int estimateInSec) {
        this.estimateInSec = estimateInSec;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public WorkingQueueDto setStatus(String status) {
        this.status = status;
        return this;
    }
}
