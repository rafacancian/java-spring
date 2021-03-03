package springdata.company.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springdata.company.dtos.PositionDTO;
import springdata.company.entities.Position;
import springdata.company.usecases.PositionUsecase;

import java.util.List;

@RestController
@RequestMapping("/positions")
@AllArgsConstructor
public class PositionsController {

    PositionUsecase positionUsecase;

    @GetMapping
    public ResponseEntity<List<PositionDTO>> findAll() {
        final List<PositionDTO> result = positionUsecase.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping
    public ResponseEntity<PositionDTO> create(@RequestBody Position position) {
        final PositionDTO positionDTO = positionUsecase.create(position);
        return ResponseEntity.status(HttpStatus.CREATED).body(positionDTO);
    }

    @PutMapping
    public ResponseEntity<PositionDTO> update(@RequestBody Position position) {
        final PositionDTO positionDTO = positionUsecase.create(position);
        return ResponseEntity.status(HttpStatus.OK).body(positionDTO);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Integer id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
