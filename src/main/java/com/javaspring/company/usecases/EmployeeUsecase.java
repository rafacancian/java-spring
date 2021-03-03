package com.javaspring.company.usecases;

import com.javaspring.company.adapters.EmployeeAdapter;
import com.javaspring.company.dtos.EmployeeDTO;
import com.javaspring.company.entities.Employee;
import com.javaspring.company.entities.projections.EmployeeProjection;
import com.javaspring.company.external.repositories.EmployeeRepository;
import com.javaspring.company.specification.EmployeeSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
