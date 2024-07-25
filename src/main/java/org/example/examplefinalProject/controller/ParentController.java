package org.example.examplefinalProject.controller;

import org.example.examplefinalProject.service.ParentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @DeleteMapping("/delete")
    public String deleteParent(@RequestParam Integer parentId) {
        parentService.delete(parentId);
        //  log.info(String.format("Uživatel vymazal parent s id '%s'", parentId));
        return "redirect:/";
    }

 /*   @DeleteMapping("/delete")
    public void deleteParent(@RequestParam Integer parentId){
        parentService.delete(parentId);
    }*/
}
