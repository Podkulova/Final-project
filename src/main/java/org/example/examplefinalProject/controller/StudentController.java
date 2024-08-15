package org.example.examplefinalProject.controller;

import lombok.Builder;
import org.example.examplefinalProject.exception.ClassRoomNotFoundException;
import org.example.examplefinalProject.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Builder
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("student/index");
        modelAndView.addObject("studentList", studentService.findAll());
        return modelAndView;
    }

    @GetMapping("/{studentId}")
    public ModelAndView detail(@PathVariable int studentId) {
        ModelAndView modelAndView = new ModelAndView("/student/detail");
        modelAndView.addObject("student", studentService.findById(studentId));
        return modelAndView;
    }

    @PostMapping("/createStudent")
    public String createStudent(@RequestParam String studentName,
                                @RequestParam String studentSurname,
                                @RequestParam String classRoomName,
                                RedirectAttributes redirectAttributes) {
        try {
            studentService.createStudent(studentName, studentSurname, classRoomName);
            redirectAttributes.addFlashAttribute("message", "Student was created.");
        } catch (ClassRoomNotFoundException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/student";
    }
}
