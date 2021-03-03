package springdata.company.external.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springdata.company.entities.Workstation;

@Repository
public interface WorkstationRepository extends JpaRepository<Workstation, Integer> {
}
