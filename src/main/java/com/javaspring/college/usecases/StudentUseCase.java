package com.javaspring.college.usecases;


import com.javaspring.college.entities.Student;
import com.javaspring.college.external.gateways.StudentGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
