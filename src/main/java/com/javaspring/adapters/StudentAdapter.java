package com.javaspring.adapters;


import com.javaspring.dtos.StudentDTO;
import com.javaspring.entities.Student;

public class StudentAdapter {

    public static Student ToModel(StudentDTO studentDTO) {
        return Student.builder().name(studentDTO.getName())
                .cpf(studentDTO.getCpf())
                .email(studentDTO.getEmail())
                .phones(PhoneAdapter.ToModel(studentDTO.getPhones()))
                .build();
    }
}
