package com.javaspring.company.usecases;

import com.javaspring.company.entities.Employee;
import com.javaspring.company.external.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeUsecase {

    private EmployeeRepository repository;

    public List<Employee> findAll() {
        List<Employee> result = repository.findAll();
        if (ObjectUtils.isEmpty(result)) {
            throw new EntityNotFoundException("Positions not found");
        }
        return result;
    }


    public Employee create(Employee employee) {
        return repository.save(employee);
    }

}
