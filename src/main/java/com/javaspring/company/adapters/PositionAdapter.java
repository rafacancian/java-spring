package com.javaspring.company.adapters;

import com.javaspring.company.dtos.PositionDTO;
import com.javaspring.company.entities.Position;

import java.util.List;

public class PositionAdapter {
    public static PositionDTO toModel(Position result) {
        return PositionDTO.builder().build();

    }

    public static List<PositionDTO> toModel(List<Position> result) {
        return List.of();
    }
}
