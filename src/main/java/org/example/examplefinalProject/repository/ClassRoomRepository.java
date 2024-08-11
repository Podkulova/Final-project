package org.example.examplefinalProject.repository;

import org.example.examplefinalProject.entity.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom, Integer> {
    ClassRoom findByClassRoomName (String classRoomName);

    ClassRoom findByClassRoomId (Integer classRoomId);
}
