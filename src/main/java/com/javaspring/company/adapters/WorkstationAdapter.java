package com.javaspring.company.adapters;

import com.javaspring.company.dtos.WorkstationDTO;
import com.javaspring.company.entities.Workstation;

import java.util.List;

public class WorkstationAdapter {
    public static WorkstationDTO toModel(Workstation result) {
        return WorkstationDTO.builder().build();
    }

    public static List<WorkstationDTO> toModel(List<Workstation> result) {
        return List.of();
    }
}
