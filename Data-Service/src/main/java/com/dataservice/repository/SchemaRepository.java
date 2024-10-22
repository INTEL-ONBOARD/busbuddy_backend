package com.dataservice.repository;

import com.dataservice.model.SchemaMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchemaRepository extends JpaRepository<SchemaMap, Long> {
}
