package springdata.college.adapters;


import springdata.college.dtos.StudentDTO;
import springdata.college.entities.Student;

public class StudentAdapter {

    public static Student ToModel(StudentDTO studentDTO) {
        return Student.builder().name(studentDTO.getName())
                .cpf(studentDTO.getCpf())
                .email(studentDTO.getEmail())
                .phones(PhoneAdapter.ToModel(studentDTO.getPhones()))
                .build();
    }
}
