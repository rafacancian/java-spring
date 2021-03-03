package springdata.company.usecases;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import springdata.company.adapters.WorkstationAdapter;
import springdata.company.dtos.WorkstationDTO;
import springdata.company.entities.Workstation;
import springdata.company.external.repositories.WorkstationRepository;

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
