package org.example.examplefinalProject.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.examplefinalProject.entity.ClassRoom;
import org.example.examplefinalProject.exception.TeacherNotFoundException;
import org.example.examplefinalProject.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/teacher/index");
        modelAndView.addObject("teacherList", teacherService.findAll());
        return modelAndView;
    }

    @GetMapping("/{teacherId}")
    public ModelAndView detail(@PathVariable int teacherId) {
        ModelAndView modelAndView = new ModelAndView("/teacher/detail");
        modelAndView.addObject("teacher", teacherService.findById(teacherId));
        return modelAndView;
    }

    @PostMapping("/createTeacher")
    public String createTeacher(@RequestParam String teacherName,
                                @RequestParam String teacherSurname,
                                @RequestParam String classRoomName) {
        teacherService.createTeacher(teacherName, teacherSurname, classRoomName);
        return "redirect:/teacher";
    }

    @PostMapping("/deleteTeacher")
    public String deleteTeacher(@RequestParam("teacherId") Integer teacherId, RedirectAttributes redirectAttributes) {
        try {
            teacherService.deleteTeacher(teacherId);
            redirectAttributes.addFlashAttribute("message", "Teacher was deleted.");
        } catch (TeacherNotFoundException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/teacher";
    }
}
