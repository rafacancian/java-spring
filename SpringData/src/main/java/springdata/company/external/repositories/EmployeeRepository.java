package springdata.company.external.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import springdata.company.entities.Employee;
import springdata.company.entities.projections.EmployeeProjection;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {

    @Query("SELECT e FROM Employee e JOIN e.position p WHERE p.description = :description")
    Optional<List<Employee>> findByPositionDescription(String description);

    @Query(value = "SELECT e.id, e.name, e.salary FROM employees e", nativeQuery = true)
    Optional<List<EmployeeProjection>> findAllNameAndSalary();

    Optional<List<Employee>> findByName(String name);
}
