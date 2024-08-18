package org.example.examplefinalProject.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classRoomId;

    private String classRoomName;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacherId")
    private Teacher classTeacher;

    @OneToMany(mappedBy = "classRoom")
    @OrderBy(value = "studentSurname, studentName")
    private List<Student> students;

    @Override
    public String toString() {
        return classRoomName;
    }
}









