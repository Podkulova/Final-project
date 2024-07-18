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

    /**
     * Vrací seznam všech tříd.
     *
     * @return Seznam tříd.
     */
    public List<ClassRoom> findAll() {
        return classRoomRepository.findAll();
    }

    /**
     * Vrací detail třídy.
     *
     // @param id Identifikátor třídy.
     * @return Detail třídy nebo {@code null}.
     */
    public ClassRoom findById(int classroomId) {
        return classRoomRepository.findById(classroomId).orElse(null);
    }

    /**
     * Vrací počet studentů v dané třídě.
     *
     // @param id Identifikátor třídy.
     * @return Počet studentů.
     */
    public int studentCountById(int classRoomId) {
        return studentRepository.countByClassRoomId(classRoomId);
    }

}
