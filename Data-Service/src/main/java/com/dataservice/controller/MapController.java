package com.dataservice.controller;


import com.dataservice.model.Map;
import com.dataservice.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maps")
public class MapController {

    @Autowired
    private MapService mapService;

    @GetMapping
    public List<Map> getAllMaps() {
        return mapService.getAllMaps();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map> getMapById(@PathVariable Long id) {
        return mapService.getMapById(id)
                .map(map -> ResponseEntity.ok(map))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Map createMap(@RequestBody Map map) {
        return mapService.saveMap(map);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMap(@PathVariable Long id) {
        mapService.deleteMap(id);
        return ResponseEntity.noContent().build();
    }
}
