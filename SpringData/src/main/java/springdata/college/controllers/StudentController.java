package springdata.college.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springdata.college.adapters.StudentAdapter;
import springdata.college.dtos.StudentDTO;
import springdata.college.entities.Student;
import springdata.college.usecases.StudentUseCase;

import java.util.List;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    StudentUseCase studentUseCase;

    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        List<Student> students = studentUseCase.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody StudentDTO studentDTO) {
        Student student = studentUseCase.create(StudentAdapter.ToModel(studentDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
}
