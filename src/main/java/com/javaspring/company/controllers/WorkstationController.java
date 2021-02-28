package com.javaspring.company.controllers;


import com.javaspring.company.dtos.WorkstationDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workstations")
@AllArgsConstructor
public class WorkstationController {

    @GetMapping
    public ResponseEntity<List<WorkstationDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(List.of());
    }

    @PostMapping
    public ResponseEntity<WorkstationDTO> create(@RequestBody WorkstationDTO WorkstationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(WorkstationDTO);
    }

    @PutMapping
    public ResponseEntity<WorkstationDTO> update(@RequestBody WorkstationDTO WorkstationDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(WorkstationDTO);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Integer id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
