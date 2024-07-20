package org.example.examplefinalProject.repository;

import org.example.examplefinalProject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    int countByClassRoomClassRoomId (Integer classRoomId);

}
