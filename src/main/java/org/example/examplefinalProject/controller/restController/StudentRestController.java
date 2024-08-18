package org.example.examplefinalProject.controller.restController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.examplefinalProject.entity.Student;
import org.example.examplefinalProject.entity.dto.StudentDTO;
import org.example.examplefinalProject.service.MyCustomMapper;
import org.example.examplefinalProject.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/student")
@CrossOrigin()
public class StudentRestController {

    private final StudentService studentService;
    private final MyCustomMapper myCustomMapper;

    @GetMapping("")
    public List<StudentDTO> getAllStudents() {
        List<StudentDTO> studentsDto = studentService.findAll().stream()
                .map(myCustomMapper::convertToDTO)
                .toList();
        return studentsDto;
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

    @GetMapping("/{classRoomId}")
    public ResponseEntity<List<Student>> getStudentsByClassRoomId(@PathVariable Integer classRoomId) {
        List<Student> students = studentService.findByClassRoomId(classRoomId);
        if (students != null && !students.isEmpty()) {
            return ResponseEntity.ok(students);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.noContent().build();
    }
}
