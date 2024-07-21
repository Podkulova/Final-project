package org.example.examplefinalProject.controller.restController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.examplefinalProject.entity.Teacher;
import org.example.examplefinalProject.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/v2")
public class TeacherRestController {
    private final TeacherService teacherService;

    @GetMapping("")
    public ResponseEntity<List<Teacher>> index() {
        return ResponseEntity.ok(teacherService.findAll());
    }

    @GetMapping("/{parentId}")
    public ResponseEntity<Teacher> detail(@PathVariable int teacherId) {
        Teacher teacher = teacherService.findById(teacherId);
        if (teacher != null) {
            return ResponseEntity.ok(teacher);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

