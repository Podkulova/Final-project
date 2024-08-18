package org.example.examplefinalProject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "teacherId")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherId;

    private String teacherName;
    private String teacherSurname;

    @OneToOne(mappedBy = "classTeacher")
    @JsonBackReference
    private ClassRoom classRoom;

    @Override
    public String toString() {
        return String.format("%s %s [%d]", teacherName, teacherSurname, teacherId);
    }
}
