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

    public ClassRoom findById(int classRoomId) {
        return classRoomRepository.findById(classRoomId).orElse(null);
    }

    /**
     * Vrací seznam všech tříd.
     *
     * @return Seznam tříd.
     */
    public ClassRoomService(ClassRoomRepository classRoomRepository, StudentRepository studentRepository) {
        this.classRoomRepository = classRoomRepository;
        this.studentRepository = studentRepository;
    }

    /**
     * Vrací detail třídy.
     *
     // @param id Identifikátor třídy.
     * @return Detail třídy nebo {@code null}.
     */
    public List<ClassRoom> findAll() {
        return classRoomRepository.findAll();
    }

    /**
     * Vrací počet studentů v dané třídě.
     *
     // @param id Identifikátor třídy.
     * @return Počet studentů.
     */
    public int studentCountById(int classRoomId) {
        return studentRepository.countByClassRoomClassRoomId(classRoomId);
    }


}
