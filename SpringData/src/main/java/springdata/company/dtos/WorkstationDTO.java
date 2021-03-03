package springdata.company.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WorkstationDTO implements Serializable {

    private String city;
    private String cep;
    private String name;
    private String description;
}






