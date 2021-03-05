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
        return result.stream().map(EmployeeAdapter::toModel).collect(Collectors.toList());
    }
}
