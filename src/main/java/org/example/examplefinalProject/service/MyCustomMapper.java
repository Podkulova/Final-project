package org.example.examplefinalProject.service;

import org.example.examplefinalProject.entity.Parent;
import org.example.examplefinalProject.entity.Student;
import org.example.examplefinalProject.entity.dto.ParentDTO;
import org.example.examplefinalProject.entity.dto.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MyCustomMapper {
    public StudentDTO convertToDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setStudentId(student.getStudentId());
        dto.setStudentName(student.getStudentName());
        dto.setStudentSurname(student.getStudentSurname());
        dto.setFullName(student.getFullName());
        dto.setParents(student.getParents().stream()
                .map(this::convertParentToDTO)
                .collect(Collectors.toList()));
        return dto;
    }

    private ParentDTO convertParentToDTO(Parent parent) {
        ParentDTO dto = new ParentDTO();
        dto.setParentId(parent.getParentId());
        dto.setParentName(parent.getParentName());
        dto.setParentSurname(parent.getParentSurname());
        dto.setParentEmail(parent.getParentEmail());
        dto.setParentPhone(parent.getParentPhone());
        dto.setParentFullName(parent.getParentFullName());
        return dto;
    }

}
