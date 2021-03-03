package springdata.company.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "positions")
@Data
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description", nullable = false)
    private String description;

//    @Fetch(FetchMode.SELECT)
//    @OneToMany(mappedBy = "position", fetch = FetchType.LAZY)
//    private List<Employee> employees;
}
