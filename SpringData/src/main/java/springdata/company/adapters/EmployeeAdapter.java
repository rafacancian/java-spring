package springdata.company.adapters;

import springdata.company.dtos.EmployeeDTO;
import springdata.company.entities.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeAdapter {
    public static EmployeeDTO toModel(Employee result) {
        return EmployeeDTO.builder()
                .name(result.getName())
                .cpf(result.getCpf())
                .address(result.getAddress())
                .birthday(result.getBirthday())
                .phone(result.getPhone())
                .salary(result.getSalary())
                .hiringDate(result.getHiringDate())
                .position(result.getPosition())
                .workstations(WorkstationAdapter.toModel(result.getWorkstations()))
                .build();
    }

    public static List<EmployeeDTO> toModel(List<Employee> result) {
        return result.stream().map(r -> EmployeeDTO.builder()
                .name(r.getName())
                .cpf(r.getCpf())
                .address(r.getAddress())
                .birthday(r.getBirthday())
                .phone(r.getPhone())
                .salary(r.getSalary())
                .hiringDate(r.getHiringDate())
                .position(r.getPosition())
                .workstations(WorkstationAdapter.toModel(r.getWorkstations()))
                .build()).collect(Collectors.toList());
    }
}
