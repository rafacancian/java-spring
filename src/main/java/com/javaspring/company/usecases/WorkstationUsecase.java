package com.javaspring.company.usecases;

import com.javaspring.company.adapters.WorkstationAdapter;
import com.javaspring.company.dtos.WorkstationDTO;
import com.javaspring.company.entities.Workstation;
import com.javaspring.company.external.repositories.WorkstationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class WorkstationUsecase {

    private WorkstationRepository repository;

    public List<WorkstationDTO> findAll() {
        List<Workstation> result = repository.findAll();
        if (ObjectUtils.isEmpty(result)) {
            throw new EntityNotFoundException("Workstations not found");
        }
        return WorkstationAdapter.toModel(result);
    }


    public WorkstationDTO create(Workstation Workstation) {
        Workstation result = repository.save(Workstation);
        return WorkstationAdapter.toModel(result);
    }

}
