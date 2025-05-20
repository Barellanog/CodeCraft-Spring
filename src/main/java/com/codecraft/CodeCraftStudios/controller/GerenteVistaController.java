package com.codecraft.CodeCraftStudios.controller;

import com.codecraft.CodeCraftStudios.model.Gerente;
import com.codecraft.CodeCraftStudios.service.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/gerentes")
public class GerenteVistaController {

    @Autowired
    private GerenteService gerenteService;

    @GetMapping
    public String mostrarGerentes(Model model) {
        model.addAttribute("gerentes", gerenteService.getGerentes());
        return "gerentes"; // Se espera que exista un archivo gerentes.html en /templates
    }

    @PostMapping("/agregar")
    public String agregarGerente(@ModelAttribute Gerente gerente) {
        gerenteService.saveGerente(gerente);
        return "redirect:/gerentes";
    }
}
