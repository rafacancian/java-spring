package springdata.company.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springdata.company.dtos.EmployeeDTO;
import springdata.company.entities.Employee;
import springdata.company.entities.projections.EmployeeProjection;
import springdata.company.exceptions.ControllerException;
import springdata.company.usecases.EmployeeUsecase;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController extends ControllerException {

    private EmployeeUsecase employeeUsecase;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findAll() {
        final List<EmployeeDTO> result = employeeUsecase.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/resume")
    public ResponseEntity<List<EmployeeProjection>> findNameAndSalary() {
        final List<EmployeeProjection> result = employeeUsecase.findAllNameAndSalary();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<EmployeeDTO>> findByName(@PathVariable("name") String name) {
        final List<EmployeeDTO> result = employeeUsecase.findByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/search")
    public ResponseEntity<List<EmployeeDTO>> search(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "cpf", required = false) String cpf,
            @RequestParam(value = "salary", required = false) String salary) {
        final List<EmployeeDTO> result = employeeUsecase.search(name, cpf, salary);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        final Employee result = employeeUsecase.create(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        final Employee result = employeeUsecase.create(employee);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam Integer id) {
        final Optional<Employee> result = employeeUsecase.findById(id);
        result.ifPresent(employee -> employeeUsecase.delete(employee));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
