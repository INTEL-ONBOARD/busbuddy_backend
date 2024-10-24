package com.dataservice.controller;

import com.dataservice.model.Map;
import com.dataservice.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maps")
@CrossOrigin("http://localhost:5174")
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

    // Add the PUT mapping to update an existing Map
    @PutMapping("/{id}")
    public ResponseEntity<Map> updateMap(@PathVariable Long id, @RequestBody Map updatedMap) {
        return mapService.getMapById(id)
                .map(existingMap -> {
                    // Update the properties of the existing map with the new data
                    existingMap.setMilestone(updatedMap.getMilestone());
                    existingMap.setInfo(updatedMap.getInfo());
                    existingMap.setSchemaMap(updatedMap.getSchemaMap());

                    // Save the updated map
                    Map savedMap = mapService.saveMap(existingMap);
                    return ResponseEntity.ok(savedMap);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMap(@PathVariable Long id) {
        mapService.deleteMap(id);
        return ResponseEntity.noContent().build();
    }
}
