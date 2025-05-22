package com.codecraft.CodeCraftStudios.controller;

import com.codecraft.CodeCraftStudios.model.Administrador;
import com.codecraft.CodeCraftStudios.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/administradores")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @GetMapping
    public ResponseEntity<List<Administrador>> listarAdministradores() {
        List<Administrador> administradores = administradorService.getAdministradores();
        if (administradores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(administradores);
    }

    @PostMapping
    public ResponseEntity<Administrador> agregarAdministrador(@RequestBody Administrador admin) {
        Administrador nuevo = administradorService.saveAdministrador(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @GetMapping("{id}")
    public ResponseEntity<Administrador> buscarAdministrador(@PathVariable int id) {
        try {
            Administrador admin = administradorService.getAdministradorId(id);
            return ResponseEntity.ok(admin);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Administrador> actualizarAdministrador(@PathVariable int id, @RequestBody Administrador admin) {
        try {
            Administrador existente = administradorService.getAdministradorId(id);
            existente.setNombre(admin.getNombre());
            existente.setEmail(admin.getEmail());
            existente.setCargo(admin.getCargo());
            existente.setNivelAcceso(admin.getNivelAcceso());
            existente.setTelefono(admin.getTelefono());
            existente.setObservaciones(admin.getObservaciones());

            administradorService.saveAdministrador(existente);
            return ResponseEntity.ok(existente);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarAdministrador(@PathVariable int id) {
        try {
            administradorService.deleteAdministrador(id);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
