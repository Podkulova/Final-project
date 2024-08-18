package org.example.examplefinalProject.controller.restController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.examplefinalProject.entity.ClassRoom;
import org.example.examplefinalProject.entity.Student;
import org.example.examplefinalProject.entity.dto.StudentDTO;
import org.example.examplefinalProject.exception.ClassRoomNotFoundException;
import org.example.examplefinalProject.service.ClassRoomService;
import org.example.examplefinalProject.service.MyCustomMapper;
import org.example.examplefinalProject.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/student")
@CrossOrigin()
public class StudentRestController {

    private final StudentService studentService;
    private final MyCustomMapper myCustomMapper;
    private final ClassRoomService classRoomService;

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

    @PostMapping("/createStudent")
    public String createStudent(@RequestParam String studentName,
                                @RequestParam String studentSurname,
                                @RequestParam Integer classRoomId,
                                RedirectAttributes redirectAttributes) {
        try {
            ClassRoom classRoom = classRoomService.findById(classRoomId);
            studentService.createStudent(studentName, studentSurname, classRoom.getClassRoomName());
            redirectAttributes.addFlashAttribute("message", "Student was created.");
        } catch (ClassRoomNotFoundException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/student";
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.noContent().build();
    }
}
