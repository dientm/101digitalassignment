package com.digital.assignment.coreservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.assignment.coreservice.entity.Product;
import com.digital.assignment.coreservice.entity.Queue;
import com.digital.assignment.coreservice.entity.Shop;
import com.digital.assignment.coreservice.exception.ShopNotFoundException;
import com.digital.assignment.coreservice.repository.QueueRepository;
import com.digital.assignment.coreservice.repository.ShopRepository;

import dto.ShopDto;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private QueueRepository queueRepository;

    @Autowired
    private ProductService productService;


    public Shop save(ShopDto shopDto) {
        Shop shop = new Shop();
        shop.setName(shopDto.getName());
        shop.setContact(shopDto.getContact());
        shop.setLocation(shopDto.getLocation());

        final List<Long> productIds = shopDto.getProducts();
        final List<Product> products = productService.getByIds(productIds);

        shop.setProducts(products);

        final int queueSize = shopDto.getQueueSize();
        List<Queue> queues = new ArrayList<>();
        for (int i = 0; i < queueSize; i++) {
            Queue queue = new Queue();
            queue.setMaxNumber(shopDto.getMaxQueueSize());
            queue.setShop(shop);
            queues.add(queue);
        }
        shop.setQueues(queues);
        Shop entity = shopRepository.saveAndFlush(shop);

        return shopRepository.findById(entity.getId()).orElse(null);
    }
    
    public Shop getById(long shopId) throws ShopNotFoundException {
        return shopRepository.findById(shopId).orElseThrow(()-> new ShopNotFoundException(shopId));
    }

}
