package com.javaspring.company.adapters;

import com.javaspring.company.dtos.WorkstationDTO;
import com.javaspring.company.entities.Workstation;

import java.util.ArrayList;
import java.util.List;

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
        List<WorkstationDTO> workstationDTOS = new ArrayList<>();
        result.forEach(r -> workstationDTOS.add(
                WorkstationDTO.builder()
                        .cep(r.getCep())
                        .city(r.getCity())
                        .name(r.getName())
                        .description(r.getDescription())
                        .build()));
        return workstationDTOS;
    }
}
