package springdata.company.usecases;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import springdata.company.adapters.EmployeeAdapter;
import springdata.company.dtos.EmployeeDTO;
import springdata.company.entities.Employee;
import springdata.company.entities.projections.EmployeeProjection;
import springdata.company.external.repositories.EmployeeRepository;
import springdata.company.specification.EmployeeSpecification;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeUsecase {

    private EmployeeRepository repository;

    public List<EmployeeDTO> findAll() {
        List<Employee> result = repository.findAll();
        if (ObjectUtils.isEmpty(result)) {
            throw new EntityNotFoundException("Positions not found");
        }
        return EmployeeAdapter.toModel(result);
    }

    public List<EmployeeProjection> findAllNameAndSalary() {
        return repository.findAllNameAndSalary()
                .orElseThrow(() -> new EntityNotFoundException("The list of employee is empty"));
    }

    public List<EmployeeDTO> findByName(final String name) {
        List<Employee> result = repository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Employee with name " + name + " not found"));
        return EmployeeAdapter.toModel(result);

    }

    public List<EmployeeDTO> search(final String name, final String cpf, final String salary) {
        List<Employee> result = repository.findAll(Specification.where(
                EmployeeSpecification.name(name)
                        .or(EmployeeSpecification.cpf(cpf))
                        .or(EmployeeSpecification.salary(convertSalaryStringToBigDecimal(salary)))
                )
        );
        if (result.isEmpty()) {
            throw new EntityNotFoundException("Employee with name " + name + " not found");
        }
        return EmployeeAdapter.toModel(result);
    }

    private BigDecimal convertSalaryStringToBigDecimal(String salary) {
        try {
            if (salary == null) {
                return BigDecimal.ZERO;
            }
            BigDecimal salaryConverted = new BigDecimal(salary);
            return salaryConverted;
        } catch (Exception e) {
            throw new ArithmeticException("The salary param is invalid");
        }
    }


    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    public Optional<Employee> findById(Integer id) {
        return repository.findById(id);
    }

    public void delete(Employee employee) {
        repository.delete(employee);
    }
}
