package org.example.examplefinalProject.service;

import org.example.examplefinalProject.entity.Student;
import org.example.examplefinalProject.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student findById(int id){
        return studentRepository.findById(id).orElse(null);
    }

}
