package com.dataservice.controller;

import com.dataservice.model.Price;
import com.dataservice.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prices")
@CrossOrigin("http://localhost:5174")
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

    // PUT endpoint for updating an existing Price
    @PutMapping("/{id}")
    public ResponseEntity<Price> updatePrice(@PathVariable Long id, @RequestBody Price updatedPrice) {
        return priceService.getPriceById(id)
                .map(existingPrice -> {
                    // Update existing Price properties
                    existingPrice.setMilestone(updatedPrice.getMilestone());
                    existingPrice.setOldPrice(updatedPrice.getOldPrice());
                    existingPrice.setNewPrice(updatedPrice.getNewPrice());

                    // Save the updated price entity
                    Price savedPrice = priceService.savePrice(existingPrice);
                    return ResponseEntity.ok(savedPrice);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrice(@PathVariable Long id) {
        priceService.deletePrice(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/milestone")
    public ResponseEntity<Price> getPriceByMilestone(@RequestParam String milestone) {
        return priceService.findByMilestone(milestone)
                .map(price -> ResponseEntity.ok(price))
                .orElse(ResponseEntity.notFound().build());
    }
}
