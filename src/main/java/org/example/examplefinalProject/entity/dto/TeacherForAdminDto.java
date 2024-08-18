package org.example.examplefinalProject.entity.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class TeacherForAdminDto {
    private Long teacherId;
    private String teacherName;
    private String surnameName;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
}
