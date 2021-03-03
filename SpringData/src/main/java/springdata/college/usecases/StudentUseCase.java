package springdata.college.usecases;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import springdata.college.entities.Student;
import springdata.college.external.gateways.StudentGateway;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentUseCase {

    private StudentGateway studentGateway;

    public Student create(Student student) {
        return studentGateway.create(student);
    }

    public List<Student> findAll() {
        List<Student> students = studentGateway.findAll();
        if (ObjectUtils.isEmpty(students)) {
            throw new EntityNotFoundException("Students not found");
        }
        return students;
    }
}
