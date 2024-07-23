package org.example.examplefinalProject.controller.restController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.examplefinalProject.entity.Student;
import org.example.examplefinalProject.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/student")
@CrossOrigin()
public class StudentRestController {

    private final StudentService studentService;

    @GetMapping("")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable int studentId) {
        Student student = studentService.findById(studentId);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
