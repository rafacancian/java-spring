package com.javaspring.company.controllers;


import com.javaspring.company.dtos.WorkstationDTO;
import com.javaspring.company.entities.Workstation;
import com.javaspring.company.usecases.WorkstationUsecase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workstations")
@AllArgsConstructor
public class WorkstationController {

    private WorkstationUsecase workstationUsecase;

    @GetMapping
    public ResponseEntity<List<WorkstationDTO>> findAll() {
        final List<WorkstationDTO> result = workstationUsecase.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping
    public ResponseEntity<WorkstationDTO> create(@RequestBody Workstation Workstation) {
        final WorkstationDTO result = workstationUsecase.create(Workstation);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping
    public ResponseEntity<WorkstationDTO> update(@RequestBody Workstation Workstation) {
        final WorkstationDTO result = workstationUsecase.create(Workstation);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Integer id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
