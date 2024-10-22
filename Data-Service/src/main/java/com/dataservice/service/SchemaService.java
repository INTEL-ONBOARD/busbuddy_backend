package com.dataservice.service;

import com.dataservice.model.SchemaMap;
import com.dataservice.repository.SchemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchemaService {
    @Autowired
    private SchemaRepository schemaRepository;

    public List<SchemaMap> getAllSchemas() {
        return schemaRepository.findAll();
    }

    public Optional<SchemaMap> getSchemaById(Long id) {
        return schemaRepository.findById(id);
    }

    public SchemaMap saveSchema(SchemaMap schemaMap) {
        return schemaRepository.save(schemaMap);
    }

    public void deleteSchema(Long id) {
        schemaRepository.deleteById(id);
    }
}
