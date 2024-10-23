package com.dataservice.controller;

import com.dataservice.model.SchemaMap;
import com.dataservice.service.SchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schemas")
@CrossOrigin("http://localhost:5173")
public class SchemaController {

    @Autowired
    private SchemaService schemaService;

    @GetMapping
    public List<SchemaMap> getAllSchemas() {
        return schemaService.getAllSchemas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchemaMap> getSchemaById(@PathVariable Long id) {
        return schemaService.getSchemaById(id)
                .map(schema -> ResponseEntity.ok(schema))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SchemaMap createSchema(@RequestBody SchemaMap schemaMap) {
        return schemaService.saveSchema(schemaMap);
    }

    // PUT method to update an existing SchemaMap
    @PutMapping("/{id}")
    public ResponseEntity<SchemaMap> updateSchema(@PathVariable Long id, @RequestBody SchemaMap schemaDetails) {
        return schemaService.getSchemaById(id)
                .map(existingSchema -> {
                    existingSchema.setName(schemaDetails.getName());
                    existingSchema.setRouteFrom(schemaDetails.getRouteFrom());
                    existingSchema.setRouteTo(schemaDetails.getRouteTo());
                    SchemaMap updatedSchema = schemaService.saveSchema(existingSchema);
                    return ResponseEntity.ok(updatedSchema);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchema(@PathVariable Long id) {
        schemaService.deleteSchema(id);
        return ResponseEntity.noContent().build();
    }
}
