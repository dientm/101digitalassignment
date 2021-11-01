package com.digital.assignment.coreservice.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.assignment.coreservice.entity.Product;
import com.digital.assignment.coreservice.repository.ProductRepository;

import dto.ProductDto;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getByIds(Collection<Long> ids) {
        return productRepository.findAllById(ids);
    }

    public Product getById(long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public Product save(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        return productRepository.save(product);
    }
}
