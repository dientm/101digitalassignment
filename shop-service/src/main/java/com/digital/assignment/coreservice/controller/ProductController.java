package com.digital.assignment.coreservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digital.assignment.coreservice.entity.Product;
import com.digital.assignment.coreservice.service.ProductService;

import dto.ProductDto;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product product(@RequestBody ProductDto productDto) {
        return productService.save(productDto);
    }

    @GetMapping(value = "/{productId}")
    public Product getProduct(@PathVariable long productId) {
        return productService.getById(productId);
    }

}
