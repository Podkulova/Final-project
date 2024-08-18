package org.example.examplefinalProject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "studentId")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    private String studentName;
    private String studentSurname;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "classRoomId")
    private ClassRoom classRoom;

    @ManyToMany
    @JoinTable(
            name = "student_parent",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "parent_id")
    )
    @OrderBy(value = "parentSurname, parentName")
    @JsonBackReference
    private List<Parent> parents;

    @Override
    public String toString() {
        return String.format("%s %s [%d]", studentName, studentSurname, studentId);
    }
}
