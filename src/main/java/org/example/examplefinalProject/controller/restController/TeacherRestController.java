package org.example.examplefinalProject.controller.restController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.examplefinalProject.entity.Teacher;
import org.example.examplefinalProject.entity.record.TeacherRecord;
import org.example.examplefinalProject.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/teacher")
public class TeacherRestController {
    private final TeacherService teacherService;

    @GetMapping("")
    public ResponseEntity<List<Teacher>> index() {
        return ResponseEntity.ok(teacherService.findAll());
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<Teacher> detail(@PathVariable int teacherId) {
        Teacher teacher = teacherService.findById(teacherId);
        if (teacher != null) {
            return ResponseEntity.ok(teacher);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/createTeacher")
    public ResponseEntity<TeacherRecord> createTeacher(@RequestBody TeacherRecord teacherRecord) {
        teacherService.createTeacher(teacherRecord.teacherName(), teacherRecord.teacherSurname(), teacherRecord.classRoom());
        return new ResponseEntity<>(teacherRecord, HttpStatus.CREATED);
    }
}

