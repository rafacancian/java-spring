package com.javaspring.company.dtos;

import com.javaspring.company.entities.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

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

}






