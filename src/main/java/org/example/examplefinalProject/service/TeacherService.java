package org.example.examplefinalProject.service;

import org.example.examplefinalProject.entity.ClassRoom;
import org.example.examplefinalProject.entity.Teacher;
import org.example.examplefinalProject.exception.InvalidParamsException;
import org.example.examplefinalProject.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher findById(Integer teacherId) {
        return teacherRepository.findById(teacherId).orElse(null);
    }

    public void createTeacher(String teacherName, String teacherSurname, ClassRoom classRoom){
        Teacher teacher = Teacher.builder()
                .teacherName(teacherName)
                .teacherSurname(teacherSurname)
                .classRoom(classRoom)
                .build();
        if (teacherName == null || teacherSurname == null){
            throw new InvalidParamsException("TeacherName or teacherSurname is not null ");
        }
        teacherRepository.save(teacher);
    }


}
