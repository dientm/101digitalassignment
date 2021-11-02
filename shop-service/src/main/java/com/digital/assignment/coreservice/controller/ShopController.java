package com.digital.assignment.coreservice.controller;

import java.util.List;
import java.util.stream.Collectors;

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

    /**
     * create new shop.
     * @param shopDto
     * @throws Exception
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ShopDto shopDto) throws Exception {
        shopService.save(shopDto);
    }

    /***
     * Get all available shop.
     * @return list of available shop.
     */
    @GetMapping
    public ResponseEntity<List<ShopDto>> fetchAll() {
        return ResponseEntity.ok(shopService.list().stream().map(Transformer::transform).collect(Collectors.toList()));
    }

    /***
     * get shop info by shop id.
     * @param shopId
     * @return shop information.
     * @throws ShopNotFoundException
     */
    @GetMapping(value = "/{shopId}")
    public ResponseEntity<ShopDto> fetchShopById(@PathVariable(value = "shopId") long shopId) throws ShopNotFoundException {
        final ShopDto shop = Transformer.transform(shopService.getById(shopId));
        return ResponseEntity.ok(shop);
    }


}
