package com.codecraft.CodeCraftStudios.controller;

import com.codecraft.CodeCraftStudios.model.Soporte;
import com.codecraft.CodeCraftStudios.service.SoporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/soportes")
public class SoporteVistaController {

    @Autowired
    private SoporteService soporteService;

    @GetMapping
    public String mostrarSoportes(Model model) {
        model.addAttribute("soportes", soporteService.getSoportes());
        return "soportes"; // Thymeleaf buscará soporte.html en /resources/templates
    }

    @PostMapping("/agregar")
    public String agregarSoporte(@ModelAttribute Soporte soporte) {
        soporteService.saveSoporte(soporte);
        return "redirect:/soportes";
    }
}
