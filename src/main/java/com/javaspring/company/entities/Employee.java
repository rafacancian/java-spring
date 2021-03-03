package com.javaspring.company.entities;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employees")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "hiringDate", nullable = false)
    private LocalDate hiringDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;

    @Fetch(FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "employee_workstation",
            joinColumns = {@JoinColumn(name = "fk_employee")},
            inverseJoinColumns = {@JoinColumn(name = "fk_workstation")})
    private List<Workstation> workstations;

}
