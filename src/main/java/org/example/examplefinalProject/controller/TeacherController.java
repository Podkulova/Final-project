package org.example.examplefinalProject.controller;

import org.example.examplefinalProject.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/teacher/index");
        modelAndView.addObject("teacher", teacherService.findAll());
        return modelAndView;
    }

    @GetMapping("/{teacherId}")
    public ModelAndView detail(@PathVariable int teacherId) {
        ModelAndView modelAndView = new ModelAndView("/teacher/detail");
        modelAndView.addObject("teacher", teacherService.findById(teacherId));
        return modelAndView;
    }
}
