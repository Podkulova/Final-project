package org.example.examplefinalProject.controller;

import org.example.examplefinalProject.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("student/index");
        modelAndView.addObject("student", studentService.findAll());
        return modelAndView;
    }

    @GetMapping("/{studentId}")
    public ModelAndView detail(@PathVariable int studentId){
        ModelAndView modelAndView = new ModelAndView("/student/detail");
        modelAndView.addObject("student", studentService.findById(studentId));
        return modelAndView;
    }
}
