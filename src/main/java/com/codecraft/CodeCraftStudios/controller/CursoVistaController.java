package com.codecraft.CodeCraftStudios.controller;

import com.codecraft.CodeCraftStudios.model.Curso;
import com.codecraft.CodeCraftStudios.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cursos")
public class CursoVistaController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public String mostrarCursos(Model model) {
        model.addAttribute("cursos", cursoService.getCursos());
        return "cursos"; // archivo cursos.html en /resources/templates/
    }

    @PostMapping("/agregar")
    public String agregarCurso(@ModelAttribute Curso curso) {
        cursoService.saveCurso(curso);
        return "redirect:/cursos";
    }
}