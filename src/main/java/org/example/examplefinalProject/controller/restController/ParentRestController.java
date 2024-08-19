package org.example.examplefinalProject.controller.restController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.examplefinalProject.entity.Parent;
import org.example.examplefinalProject.entity.Student;
import org.example.examplefinalProject.service.ParentService;
import org.example.examplefinalProject.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/parent")

public class ParentRestController {
    private final ParentService parentService;
    private final StudentService studentService;

    @GetMapping("")
    public ResponseEntity<List<Parent>> index() {
        return ResponseEntity.ok(parentService.findAll());
    }

    /*@GetMapping("/{parentId}")
    public ResponseEntity<Parent> detail(@PathVariable int parentId) {
        Parent parent = parentService.findById(parentId);
        if (parent != null) {
            return ResponseEntity.ok(parent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/
    @GetMapping("/parent/createParent")
    public String showCreateParentForm(Model model) {
        List<Student> studentList = studentService.findAll();
        model.addAttribute("studentList", studentList);
        return "createParent";
    }
    @PostMapping("/createParent")
    public String createParent(@RequestParam String parentName,
                               @RequestParam String parentSurname,
                               @RequestParam String parentEmail,
                               @RequestParam String parentPhone,
                               @RequestParam String studentFullName) {
        parentService.createParent(parentName, parentSurname, parentEmail, parentPhone, studentFullName);
        //log.info(String.format("User created teacher '%s' '%s'", teacherName, teacherSurname));
        return "redirect:/parent";
    }

    @DeleteMapping("/deleteParent/{parentId}")
    public ResponseEntity<String> deleteParent(@PathVariable Integer parentId) {
        parentService.deleteParent(parentId);
        return ResponseEntity.noContent().build();
    }
}