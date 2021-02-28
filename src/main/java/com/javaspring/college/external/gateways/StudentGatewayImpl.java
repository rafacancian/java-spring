package com.javaspring.college.external.gateways;


import com.javaspring.college.entities.Student;
import com.javaspring.college.external.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
