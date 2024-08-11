package org.example.examplefinalProject.service;

import org.example.examplefinalProject.entity.ClassRoom;
import org.example.examplefinalProject.repository.ClassRoomRepository;
import org.example.examplefinalProject.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomService {
    private final ClassRoomRepository classRoomRepository;
    private final StudentRepository studentRepository;

    public ClassRoomService(ClassRoomRepository classRoomRepository, StudentRepository studentRepository) {
        this.classRoomRepository = classRoomRepository;
        this.studentRepository = studentRepository;
    }

    public List<ClassRoom> findAll() {
        return classRoomRepository.findAll();
    }

    public ClassRoom findById(int classRoomId) {
        return classRoomRepository.findById(classRoomId).orElse(null);
    }

    public int studentCountById(int classRoomId) {
        return studentRepository.countByClassRoomClassRoomId(classRoomId);
    }


}
