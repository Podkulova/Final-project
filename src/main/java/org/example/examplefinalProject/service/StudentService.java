package org.example.examplefinalProject.service;

import lombok.Builder;
import org.example.examplefinalProject.entity.ClassRoom;
import org.example.examplefinalProject.entity.Student;
import org.example.examplefinalProject.repository.ClassRoomRepository;
import org.example.examplefinalProject.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Builder
public class StudentService {
    private final StudentRepository studentRepository;
    private final ClassRoomRepository classRoomRepository;

    public StudentService(StudentRepository studentRepository, ClassRoomRepository classRoomRepository) {
        this.studentRepository = studentRepository;
        this.classRoomRepository = classRoomRepository;
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student findById(int id){
        return studentRepository.findById(id).orElse(null);
    }

    public void createStudent(String studentName, String studentSurname, ClassRoom classRoomName) {

        Student student = Student.builder()
                .studentName(studentName)
                .studentSurname(studentSurname)
                .classRoom(classRoomName)
                .build();

       studentRepository.save(student);
    }
}
