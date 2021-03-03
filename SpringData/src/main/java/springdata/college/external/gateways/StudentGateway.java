package springdata.college.external.gateways;


import org.springframework.stereotype.Service;
import springdata.college.entities.Student;

import java.util.List;


@Service
public interface StudentGateway {

    List<Student> findAll();

    Student create(Student student);

}
