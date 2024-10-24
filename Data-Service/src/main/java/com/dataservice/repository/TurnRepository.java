package com.dataservice.repository;

import com.dataservice.model.Turn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurnRepository extends JpaRepository<Turn, Long> {
}
