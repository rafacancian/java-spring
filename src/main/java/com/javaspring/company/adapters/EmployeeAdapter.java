package com.javaspring.company.adapters;

import com.javaspring.company.dtos.EmployeeDTO;
import com.javaspring.company.entities.Employee;

import java.util.List;

public class EmployeeAdapter {
    public static EmployeeDTO toModel(Employee result) {
        return EmployeeDTO.builder()
                .name(result.getName())
                .cpf(result.getCpf())
                .address(result.getAddress())
                .birthday(result.getBirthday())
                .phone(result.getPhone())
                .salary(result.getSalary())
                .position(result.getPosition())
                .hiringDate(result.getHiringDate())
                .build();
    }

    public static List<EmployeeDTO> toModel(List<Employee> result) {
        return List.of();
    }
}
