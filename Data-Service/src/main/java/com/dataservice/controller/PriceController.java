package com.dataservice.controller;


import com.dataservice.model.Price;
import com.dataservice.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/prices")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping
    public List<Price> getAllPrices() {
        return priceService.getAllPrices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Price> getPriceById(@PathVariable Long id) {
        return priceService.getPriceById(id)
                .map(price -> ResponseEntity.ok(price))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Price createPrice(@RequestBody Price price) {
        return priceService.savePrice(price);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrice(@PathVariable Long id) {
        priceService.deletePrice(id);
        return ResponseEntity.noContent().build();
    }
}
