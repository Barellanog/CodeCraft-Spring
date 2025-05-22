package com.codecraft.CodeCraftStudios.controller;

import com.codecraft.CodeCraftStudios.model.Curso;
import com.codecraft.CodeCraftStudios.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> listarCursos() {
        List<Curso> cursos = cursoService.getCursos();
        if (cursos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cursos);
    }

    @PostMapping
    public ResponseEntity<Curso> agregarCurso(@RequestBody Curso curso) {
        Curso nuevoCurso = cursoService.saveCurso(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCurso);
    }

    @GetMapping("{id}")
    public ResponseEntity<Curso> buscarCurso(@PathVariable int id) {
        try {
            Curso curso = cursoService.getCursoId(id);
            return ResponseEntity.ok(curso);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable int id, @RequestBody Curso curso) {
        try {
            Curso existente = cursoService.getCursoId(id);
            existente.setName(curso.getName());
            existente.setDescription(curso.getDescription());
            existente.setFecha(curso.getFecha());
            existente.setHoraCurso(curso.getHoraCurso());

            cursoService.saveCurso(existente);
            return ResponseEntity.ok(existente);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarCurso(@PathVariable int id) {
        try {
            cursoService.deleteCurso(id);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}