package org.example.examplefinalProject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classRoomId;

    private String classRoomName;

    @OneToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id")
    private Teacher classTeacher;

    @OneToMany(mappedBy = "classRoom")
    @OrderBy(value = "studentSurname, studentName")
    private List<Student> students;

    public Integer getClassRoomId() {
        return classRoomId;
    }

    public void setClassRoomId(Integer classRoomId) {
        this.classRoomId = classRoomId;
    }

    public String getClassRoomName() {
        return classRoomName;
    }

    public void setClassRoomName(String classRoomName) {
        this.classRoomName = classRoomName;
    }

    public Teacher getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(Teacher classTeacher) {
        this.classTeacher = classTeacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return classRoomName;
    }
}
