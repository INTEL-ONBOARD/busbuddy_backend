package com.dataservice.controller;

import com.dataservice.model.Turn;
import com.dataservice.service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/turns")
@CrossOrigin("http://localhost:5174")
public class TurnController {

    @Autowired
    private TurnService turnService;

    @GetMapping
    public List<Turn> getAllTurns() {
        return turnService.getAllTurns();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turn> getTurnById(@PathVariable Long id) {
        return turnService.getTurnById(id)
                .map(turn -> ResponseEntity.ok(turn))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Turn createTurn(@RequestBody Turn turn) {
        return turnService.saveTurn(turn);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turn> updateTurn(@PathVariable Long id, @RequestBody Turn updatedTurn) {
        return turnService.getTurnById(id)
                .map(existingTurn -> {
                    existingTurn.setTurnNo(updatedTurn.getTurnNo());
                    existingTurn.setOrigin(updatedTurn.getOrigin());
                    existingTurn.setDeparture(updatedTurn.getDeparture());
                    existingTurn.setInfo(updatedTurn.getInfo());

                    Turn savedTurn = turnService.saveTurn(existingTurn);
                    return ResponseEntity.ok(savedTurn);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTurn(@PathVariable Long id) {
        turnService.getTurnById(id).ifPresent(turn -> turnService.deleteTurn(id));
        return ResponseEntity.noContent().build();
    }

}
