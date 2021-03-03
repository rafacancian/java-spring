package springdata.college.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentDTO implements Serializable {

    private String name;
    private String cpf;
    private String email;
    private List<PhoneDTO> phones;
}






