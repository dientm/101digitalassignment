package com.digital.assignment.coreservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.digital.assignment.coreservice.entity.Shop;
import com.digital.assignment.coreservice.exception.ShopNotFoundException;
import com.digital.assignment.coreservice.helper.Transformer;
import com.digital.assignment.coreservice.service.ShopService;

import dto.ShopDto;

@RestController
@RequestMapping(value = "/shops")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Shop> shop(@RequestBody ShopDto shopDto) {
        return ResponseEntity.ok(shopService.save(shopDto));
    }

    @GetMapping(value = "/{shopId}")
    public ResponseEntity<ShopDto> getShop(@PathVariable(value = "shopId") long shopId) {
        try {
            final ShopDto shop = Transformer.transform(shopService.getById(shopId));
            return ResponseEntity.ok(shop);
        } catch (ShopNotFoundException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


}
