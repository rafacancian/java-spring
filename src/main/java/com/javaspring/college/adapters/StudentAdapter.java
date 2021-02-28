package com.javaspring.college.adapters;


import com.javaspring.college.dtos.StudentDTO;
import com.javaspring.college.entities.Student;

public class StudentAdapter {

    public static Student ToModel(StudentDTO studentDTO) {
        return Student.builder().name(studentDTO.getName())
                .cpf(studentDTO.getCpf())
                .email(studentDTO.getEmail())
                .phones(PhoneAdapter.ToModel(studentDTO.getPhones()))
                .build();
    }
}
