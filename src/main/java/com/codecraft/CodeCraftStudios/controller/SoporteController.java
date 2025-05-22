package com.codecraft.CodeCraftStudios.controller;

import com.codecraft.CodeCraftStudios.model.Soporte;
import com.codecraft.CodeCraftStudios.service.SoporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/soportes")
public class SoporteController {

    @Autowired
    private SoporteService soporteService;

    @GetMapping
    public ResponseEntity<List<Soporte>> listarSoportes() {
        List<Soporte> soportes = soporteService.getSoportes();
        if (soportes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(soportes);
    }

    @PostMapping
    public ResponseEntity<Soporte> agregarSoporte(@RequestBody Soporte soporte) {
        Soporte nuevo = soporteService.saveSoporte(soporte);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @GetMapping("{id}")
    public ResponseEntity<Soporte> buscarSoporte(@PathVariable int id) {
        try {
            Soporte soporte = soporteService.getSoporteId(id);
            return ResponseEntity.ok(soporte);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Soporte> actualizarSoporte(@PathVariable int id, @RequestBody Soporte soporte) {
        try {
            Soporte existente = soporteService.getSoporteId(id);
            existente.setNombre(soporte.getNombre());
            existente.setEmail(soporte.getEmail());
            existente.setEspecialidad(soporte.getEspecialidad());
            existente.setDisponibilidad(soporte.getDisponibilidad());
            existente.setTelefono(soporte.getTelefono());
            existente.setObservaciones(soporte.getObservaciones());

            soporteService.saveSoporte(existente);
            return ResponseEntity.ok(existente);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarSoporte(@PathVariable int id) {
        try {
            soporteService.deleteSoporte(id);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}