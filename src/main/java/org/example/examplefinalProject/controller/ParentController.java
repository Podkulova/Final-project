package org.example.examplefinalProject.controller;

import org.example.examplefinalProject.exception.ParentNotFoundExeption;
import org.example.examplefinalProject.service.ParentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/parent")
public class ParentController {
    private final ParentService parentService;

    public ParentController(ParentService parentService){
        this.parentService = parentService;
    }

    @GetMapping("")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("parent/index");
        modelAndView.addObject("parentList", parentService.findAll());
        return modelAndView;
    }

    @GetMapping("/{parentId}")
    public ModelAndView detail(@PathVariable int parentId){
        ModelAndView modelAndView = new ModelAndView("parent/detail");
        modelAndView.addObject("parent", parentService.findById(parentId));
        return modelAndView;
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

    @PostMapping("/deleteParent")
    public String deleteParent(@RequestParam("parentId") Integer parentId, RedirectAttributes redirectAttributes){
        try {
            parentService.deleteParent(parentId);
            redirectAttributes.addFlashAttribute("message", "Parent was deleted.");
        } catch (ParentNotFoundExeption e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return"redirect:/parent";
    }
}
