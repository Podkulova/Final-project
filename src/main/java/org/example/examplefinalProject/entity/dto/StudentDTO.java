package org.example.examplefinalProject.entity.dto;

import lombok.Data;
import org.example.examplefinalProject.entity.ClassRoom;

import java.util.List;
@Data
public class StudentDTO {
    private Integer studentId;
    private String studentName;
    private String studentSurname;
    private ClassRoom classRoom;
    private List<ParentDTO> parents;
    private String fullName;
}