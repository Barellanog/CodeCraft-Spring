package com.codecraft.CodeCraftStudios.controller;

import com.codecraft.CodeCraftStudios.model.Administrador;
import com.codecraft.CodeCraftStudios.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/administradores")
public class AdministradorVistaController {

    @Autowired
    private AdministradorService administradorService;

    @GetMapping
    public String mostrarAdministradores(Model model) {
        model.addAttribute("administradores", administradorService.getAdministradores());
        return "administradores"; // Busca administradores.html en /resources/templates/
    }

    @PostMapping("/agregar")
    public String agregarAdministrador(@ModelAttribute Administrador admin) {
        administradorService.saveAdministrador(admin);
        return "redirect:/administradores";
    }
}
