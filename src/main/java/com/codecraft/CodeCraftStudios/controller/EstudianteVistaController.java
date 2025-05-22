package com.codecraft.CodeCraftStudios.controller;

import com.codecraft.CodeCraftStudios.model.Estudiante;
import com.codecraft.CodeCraftStudios.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteVistaController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public String mostrarEstudiantes(Model model) {
        model.addAttribute("estudiantes", estudianteService.getEstudiantes());
        return "estudiantes"; // Este es el nombre del archivo estudiantes.html
    }

    @PostMapping("/agregar")
    public String agregarEstudiante(@ModelAttribute Estudiante estudiante) {
        estudianteService.saveEstudiante(estudiante);
        return "redirect:/estudiantes";
    }
}