package springdata.company.adapters;

import springdata.company.dtos.WorkstationDTO;
import springdata.company.entities.Workstation;

import java.util.List;
import java.util.stream.Collectors;

public class WorkstationAdapter {
    public static WorkstationDTO toModel(Workstation result) {
        return WorkstationDTO.builder()
                .cep(result.getCep())
                .city(result.getCity())
                .name(result.getName())
                .description(result.getDescription())
                .build();
    }

    public static List<WorkstationDTO> toModel(List<Workstation> result) {
        return result.stream().map(WorkstationAdapter::toModel).collect(Collectors.toList());
    }
}
