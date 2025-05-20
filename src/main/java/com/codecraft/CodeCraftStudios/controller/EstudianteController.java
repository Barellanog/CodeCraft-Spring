package com.codecraft.CodeCraftStudios.controller;

import com.codecraft.CodeCraftStudios.model.Estudiante;
import com.codecraft.CodeCraftStudios.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public ResponseEntity<List<Estudiante>> listarEstudiantes() {
        List<Estudiante> estudiantes = estudianteService.getEstudiantes();
        if (estudiantes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estudiantes);
    }

    @PostMapping
    public ResponseEntity<Estudiante> agregarEstudiante(@RequestBody Estudiante estudiante) {
        Estudiante nuevo = estudianteService.saveEstudiante(estudiante);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @GetMapping("{id}")
    public ResponseEntity<Estudiante> buscarEstudiante(@PathVariable int id) {
        try {
            Estudiante est = estudianteService.getEstudianteId(id);
            return ResponseEntity.ok(est);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable int id, @RequestBody Estudiante estudiante) {
        try {
            Estudiante existente = estudianteService.getEstudianteId(id);
            existente.setNombre(estudiante.getNombre());
            existente.setEdad(estudiante.getEdad());
            existente.setGenero(estudiante.getGenero());
            existente.setCorreo(estudiante.getCorreo());
            existente.setTelefono(estudiante.getTelefono());

            estudianteService.saveEstudiante(existente);
            return ResponseEntity.ok(existente);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarEstudiante(@PathVariable int id) {
        try {
            estudianteService.deleteEstudiante(id);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}