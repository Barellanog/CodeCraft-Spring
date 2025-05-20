package com.codecraft.CodeCraftStudios.controller;

import com.codecraft.CodeCraftStudios.model.Instructor;
import com.codecraft.CodeCraftStudios.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/instructores")
public class InstructorVistaController {

    @Autowired
    private InstructorService instructorService;

    @GetMapping
    public String mostrarInstructores(Model model) {
        model.addAttribute("instructores", instructorService.getInstructores());
        return "instructores"; // instructores.html en /templates/
    }

    @PostMapping("/agregar")
    public String agregarInstructor(@ModelAttribute Instructor instructor) {
        instructorService.saveInstructor(instructor);
        return "redirect:/instructores";
    }
}