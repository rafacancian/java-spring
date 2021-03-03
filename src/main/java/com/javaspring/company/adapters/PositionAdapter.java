package com.javaspring.company.adapters;

import com.javaspring.company.dtos.PositionDTO;
import com.javaspring.company.entities.Position;

import java.util.List;
import java.util.stream.Collectors;

public class PositionAdapter {
    public static PositionDTO toModel(Position result) {
        return PositionDTO.builder()
                .description(result.getDescription())
                .build();

    }

    public static List<PositionDTO> toModel(List<Position> result) {
        return result.stream().map(r -> PositionDTO.builder()
                .description(r.getDescription())
                .build()).collect(Collectors.toList());

    }
}
