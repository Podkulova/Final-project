package org.example.examplefinalProject.controller.restController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.examplefinalProject.entity.ClassRoom;
import org.example.examplefinalProject.entity.Teacher;
import org.example.examplefinalProject.entity.record.TeacherRecord;
import org.example.examplefinalProject.service.ClassRoomService;
import org.example.examplefinalProject.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/teacher")
public class TeacherRestController {
    private final TeacherService teacherService;
    private final ClassRoomService classRoomService;

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

    @GetMapping("/teacher/createTeacher")
    public String showCreateTeacherForm(Model model) {
        List<ClassRoom> classRoomList = classRoomService.findAll();
        model.addAttribute("classRoomList", classRoomList);
        return "createTeacher";
    }
    @PostMapping("/createTeacher")
    public String createTeacher(@RequestParam String teacherName,
                                @RequestParam String teacherSurname,
                                @RequestParam Integer classRoomId,
                                RedirectAttributes redirectAttributes) {

        ClassRoom classRoom = classRoomService.findById(classRoomId);
        teacherService.createTeacher(teacherName, teacherSurname, classRoom.getClassRoomName());
        redirectAttributes.addFlashAttribute("message", "Student was created.");
        return "redirect:/teacher";
    }

    @DeleteMapping("/deleteTeacher/{teacherId}")
    public ResponseEntity<String> deleteTeacher(@PathVariable Integer teacherId) {
        teacherService.deleteTeacher(teacherId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

