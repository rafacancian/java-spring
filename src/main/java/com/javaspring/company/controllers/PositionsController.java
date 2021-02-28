package com.javaspring.company.controllers;


import com.javaspring.company.dtos.PositionDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/positions")
@AllArgsConstructor
public class PositionsController {

    @GetMapping
    public ResponseEntity<List<PositionDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(List.of());
    }

    @PostMapping
    public ResponseEntity<PositionDTO> create(@RequestBody PositionDTO positionDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(positionDTO);
    }

    @PutMapping
    public ResponseEntity<PositionDTO> update(@RequestBody PositionDTO positionDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(positionDTO);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Integer id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
