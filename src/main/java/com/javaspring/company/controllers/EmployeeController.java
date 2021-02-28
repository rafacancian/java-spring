package com.javaspring.company.controllers;


import com.javaspring.company.entities.Employee;
import com.javaspring.company.usecases.EmployeeUsecase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeUsecase employeeUsecase;

    @GetMapping
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> result = employeeUsecase.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        Employee result = employeeUsecase.create(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Integer id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
