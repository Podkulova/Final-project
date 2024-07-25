package org.example.examplefinalProject.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.examplefinalProject.entity.ClassRoom;
import org.example.examplefinalProject.entity.Student;
import org.example.examplefinalProject.entity.Teacher;
import org.example.examplefinalProject.service.ClassRoomService;
import org.example.examplefinalProject.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/classRoom")
@Slf4j
public class ClassRoomController {
    private final ClassRoomService classRoomService;
    private final StudentService studentService;

    public ClassRoomController(ClassRoomService classRoomService, StudentService studentService) {
        this.classRoomService = classRoomService;
        this.studentService = studentService;
    }

    @GetMapping("")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/classRoom/index");
        modelAndView.addObject("classRoomList", classRoomService.findAll());
        return modelAndView;
    }

    @GetMapping("/{classRoomId}")
    public ModelAndView detail(@PathVariable int classRoomId) {
        ModelAndView modelAndView = new ModelAndView("/classRoom/detail");

        ClassRoom classRoom = classRoomService.findById(classRoomId);


        modelAndView.addObject("classRoom", classRoomService.findById(classRoomId));
        modelAndView.addObject("studentCount", classRoomService.studentCountById(classRoomId));
        return modelAndView;
    }

    @PostMapping("/createClassRoom")
    public String createClassRoom(@RequestParam String classRoomName,
                                  @RequestParam Teacher classTeacher) {

        classRoomService.createClassRoom(classRoomName, classTeacher);
         log.info(String.format("User created '%s' '%s'", classRoomName, classTeacher));
        return "redirect:/";
    }
}
