package com.example.demo01.studentserviceimpl;

import com.example.demo01.entity.Student;
import com.example.demo01.repositiry.StudentRepository;
import com.example.demo01.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> temp = studentRepository.findById(id);
        if (temp.isPresent()) {
            return temp.get();
        } else {
            throw new RuntimeException("Student not found");
        }
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Optional<Student> temp = studentRepository.findById(id);

        if (temp.isPresent()) {
            Student dbStudent = temp.get();

            if (student.getUsername() != null) {
                dbStudent.setUsername(student.getUsername());
            }

            if (student.getPassword() != null) {
                dbStudent.setPassword(student.getPassword());
            }

            return studentRepository.save(dbStudent);
        } else {
            throw new RuntimeException("Student not found");
        }
    }

    @Override
    public Student deleteStudent(Long id) {
        Optional<Student> temp = studentRepository.findById(id);

        if (temp.isPresent()) {
            Student deletedStudent = temp.get();
            studentRepository.deleteById(id);
            return deletedStudent;
        } else {
            throw new RuntimeException("Student not found");
        }
    }
}