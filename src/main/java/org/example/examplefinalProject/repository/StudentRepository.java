package org.example.examplefinalProject.repository;

import org.example.examplefinalProject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    int countByClassRoomId(Integer classRoomId);
}
