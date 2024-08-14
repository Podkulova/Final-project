package org.example.examplefinalProject.controller;

import org.example.examplefinalProject.entity.ClassRoom;
import org.example.examplefinalProject.entity.Student;
import org.example.examplefinalProject.service.ClassRoomService;
import org.example.examplefinalProject.service.StudentService;
import org.example.examplefinalProject.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/classRoom")
public class ClassRoomController {
    private final ClassRoomService classRoomService;
    private final StudentService studentService;
    private final TeacherService teacherService;

    public ClassRoomController(ClassRoomService classRoomService, StudentService studentService, TeacherService teacherService) {
        this.classRoomService = classRoomService;
        this.studentService = studentService;
        this.teacherService = teacherService;
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
                                  @RequestParam String teacherFullName) {
        classRoomService.createClassRoom(classRoomName, teacherFullName);
        //log.info(String.format("User created teacher '%s' '%s'", teacherName, teacherSurname));
        return "redirect:/classRoom";
    }
}
