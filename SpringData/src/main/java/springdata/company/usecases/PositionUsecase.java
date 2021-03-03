package springdata.company.usecases;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import springdata.company.adapters.PositionAdapter;
import springdata.company.dtos.PositionDTO;
import springdata.company.entities.Position;
import springdata.company.external.repositories.PositionRepository;

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
