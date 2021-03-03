package springdata.company.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springdata.company.entities.Position;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmployeeDTO implements Serializable {

    private String name;
    private String cpf;
    private String address;
    private String phone;
    private BigDecimal salary;
    private LocalDate birthday;
    private LocalDate hiringDate;
    private Position position;
    private List<WorkstationDTO> workstations;

}






