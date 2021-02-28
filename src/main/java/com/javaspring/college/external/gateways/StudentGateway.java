package com.javaspring.college.external.gateways;


import com.javaspring.college.entities.Student;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface StudentGateway {

    List<Student> findAll();

    Student create(Student student);

}
