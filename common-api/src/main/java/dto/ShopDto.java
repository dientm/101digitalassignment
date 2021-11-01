package dto;

import java.util.List;

import lombok.Data;

@Data
public class ShopDto {
    private long id;
    private String name;
    private String contact;
    private String location;
    private List<Long> products;
    private int queueSize;
    private int maxQueueSize;
    private List<QueueDto> queues;

    public long getId() {
        return id;
    }

    public ShopDto setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShopDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getContact() {
        return contact;
    }

    public ShopDto setContact(String contact) {
        this.contact = contact;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public ShopDto setLocation(String location) {
        this.location = location;
        return this;
    }

    public List<Long> getProducts() {
        return products;
    }

    public ShopDto setProducts(List<Long> products) {
        this.products = products;
        return this;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public ShopDto setQueueSize(int queueSize) {
        this.queueSize = queueSize;
        return this;
    }

    public int getMaxQueueSize() {
        return maxQueueSize;
    }

    public ShopDto setMaxQueueSize(int maxQueueSize) {
        this.maxQueueSize = maxQueueSize;
        return this;
    }

    public List<QueueDto> getQueues() {
        return queues;
    }

    public ShopDto setQueues(List<QueueDto> queues) {
        this.queues = queues;
        return this;
    }
}
