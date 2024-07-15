package org.example.examplefinalProject.controller;

import org.example.examplefinalProject.service.ClassRoomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/classRoom")
public class ClassRoomController {
    private final ClassRoomService classRoomService;

    public ClassRoomController(ClassRoomService classRoomService) {
        this.classRoomService = classRoomService;
    }

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/classRoom/index");
        modelAndView.addObject("classRoom", classRoomService.findAll());
        return modelAndView;
    }

    @GetMapping("/{classRoomId}")
    public ModelAndView detail(@PathVariable int classRoomId) {
        ModelAndView modelAndView = new ModelAndView("/classRoom/detail");
        modelAndView.addObject("classRoom", classRoomService.findById(classRoomId));
        modelAndView.addObject("studentCount", classRoomService.studentCountById(classRoomId));
        return modelAndView;
    }
}
