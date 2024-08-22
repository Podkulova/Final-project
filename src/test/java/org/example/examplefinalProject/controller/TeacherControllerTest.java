package org.example.examplefinalProject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.examplefinalProject.entity.ClassRoom;
import org.example.examplefinalProject.entity.Teacher;
import org.example.examplefinalProject.service.TeacherService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(TeacherController.class)
class TeacherControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private TeacherService teacherService;
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    @Test
//    void createTeacher() throws Exception {
//
//        final Teacher teacher = new Teacher(
//                12,
//                "Pepa",
//                "Neumíučit",
//                null
//        );
//
//    /*    when(teacherService.createTeacher(anyString(), anyString(), anyString())).thenReturn(teacher);
//
//        mockMvc.perform(post("/createTeacher")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(teacher)))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.id").value(12))
//                .andExpect(jsonPath("$.name").value("Pepa"))
//                .andExpect(jsonPath("$.subject").value("Neumíučit"))
//                .andExpect(jsonPath("$.classRoom.id").value(1))
//                .andExpect(jsonPath("$.classRoom.name").value("čáry"));*/
//
//
//        // Add teacher
//        String id = mockMvc.perform(get("/teacher")
//                       /* .contentType(MediaType.APPLICATION_JSON)*/
//                       /* .content(objectMapper.writeValueAsString(teacher))*/)
//                .andExpect(status().isOk()) // 200
//                .andReturn().getResponse().getContentAsString();
//       /* teacher.setTeacherId(objectMapper.readValue(id, Integer.class));*/
//
//
//     /*   // Get teacher
//        String teacherJson = mockMvc.perform(get("/teacher" + teacher.getTeacherId()))
//                        *//*.contentType(MediaType.APPLICATION_JSON))*//*
//                .andExpect(status().isOk())
//                .andReturn().getResponse().getContentAsString();
//
//        Teacher returnedTeacher = objectMapper.readValue(teacherJson, Teacher.class);
//        Assertions.assertEquals(teacher, returnedTeacher);*/
//    }

    @Test
    void deleteTeacher() {
    }
}