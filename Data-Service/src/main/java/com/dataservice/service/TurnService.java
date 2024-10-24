package com.dataservice.service;

import com.dataservice.model.Turn;
import com.dataservice.repository.TurnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnService {

    @Autowired
    private TurnRepository turnRepository;

    public List<Turn> getAllTurns() {
        return turnRepository.findAll();
    }

    public Optional<Turn> getTurnById(Long id) {
        return turnRepository.findById(id);
    }

    public Turn saveTurn(Turn turn) {
        return turnRepository.save(turn);
    }

    public void deleteTurn(Long id) {
        turnRepository.deleteById(id);
    }
}
