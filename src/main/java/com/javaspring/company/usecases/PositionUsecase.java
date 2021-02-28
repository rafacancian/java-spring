package com.javaspring.company.usecases;

import com.javaspring.company.adapters.PositionAdapter;
import com.javaspring.company.dtos.PositionDTO;
import com.javaspring.company.entities.Position;
import com.javaspring.company.external.repositories.PositionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class PositionUsecase {

    private PositionRepository repository;

    public List<PositionDTO> findAll() {
        List<Position> result = repository.findAll();
        if (ObjectUtils.isEmpty(result)) {
            throw new EntityNotFoundException("Positions not found");
        }
        return PositionAdapter.toModel(result);
    }


    public PositionDTO create(Position position) {
        Position result = repository.save(position);
        return PositionAdapter.toModel(result);
    }

}
