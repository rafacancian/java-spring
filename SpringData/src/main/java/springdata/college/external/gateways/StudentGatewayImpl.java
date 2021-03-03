package springdata.college.external.gateways;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import springdata.college.entities.Student;
import springdata.college.external.repositories.StudentRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentGatewayImpl implements StudentGateway {

    StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }
}
