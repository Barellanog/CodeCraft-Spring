package com.codecraft.CodeCraftStudios.controller;

import com.codecraft.CodeCraftStudios.model.Gerente;
import com.codecraft.CodeCraftStudios.service.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gerentes")
public class GerenteController {

    @Autowired
    private GerenteService gerenteService;

    @GetMapping
    public ResponseEntity<List<Gerente>> listarGerentes() {
        List<Gerente> gerentes = gerenteService.getGerentes();
        if (gerentes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(gerentes);
    }

    @PostMapping
    public ResponseEntity<Gerente> agregarGerente(@RequestBody Gerente gerente) {
        Gerente nuevo = gerenteService.saveGerente(gerente);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @GetMapping("{id}")
    public ResponseEntity<Gerente> buscarGerente(@PathVariable int id) {
        try {
            Gerente g = gerenteService.getGerenteId(id);
            return ResponseEntity.ok(g);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Gerente> actualizarGerente(@PathVariable int id, @RequestBody Gerente gerente) {
        try {
            Gerente existente = gerenteService.getGerenteId(id);
            existente.setNombre(gerente.getNombre());
            existente.setEmail(gerente.getEmail());
            existente.setRol(gerente.getRol());
            existente.setCursosAsignados(gerente.getCursosAsignados());
            existente.setReportesGenerados(gerente.getReportesGenerados());

            gerenteService.saveGerente(existente);
            return ResponseEntity.ok(existente);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarGerente(@PathVariable int id) {
        try {
            gerenteService.deleteGerente(id);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}