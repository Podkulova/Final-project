package org.example.examplefinalProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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









