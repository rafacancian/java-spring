package springdata.company.adapters;

import springdata.company.dtos.PositionDTO;
import springdata.company.entities.Position;

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
