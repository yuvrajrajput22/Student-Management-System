package com.example.demo01.service;

import com.example.demo01.entity.Student;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface StudentService {

    Student addStudent(Student student);

    Student getStudentById(Long id);

    Student updateStudent(Long id,Student student);

    Student deleteStudent(Long id);

}
