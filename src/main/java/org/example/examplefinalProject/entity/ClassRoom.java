package org.example.examplefinalProject.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ClassRoomId;

    private String classRoomName;

    @OneToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "class_teacher_id")
    private Teacher classTeacher;

    @OneToMany(mappedBy = "classRoom")
    @OrderBy(value = "classTeacherSurname, classTeacherName")
    private List<Student> student;
}
