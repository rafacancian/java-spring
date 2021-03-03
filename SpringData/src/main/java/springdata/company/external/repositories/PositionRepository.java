package springdata.company.external.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdata.company.entities.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {
}
