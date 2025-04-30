package com.codecraft.CodeCraftStudios.controller;

import com.codecraft.CodeCraftStudios.model.Curso;
import com.codecraft.CodeCraftStudios.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> listarCursos() {return cursoService.getCursos();}

    @PostMapping
    public Curso agregarCurso(@RequestBody Curso curso) {return cursoService.saveCurso(curso);}

    @GetMapping("{id}")
    public Curso buscarCurso(@PathVariable int id) {return cursoService.getCursoId(id);}

    @PutMapping("{id}")
    public Curso actualizarCurso(@PathVariable int id, @RequestBody Curso curso) {
        return cursoService.updateCurso(curso);
    }

    @DeleteMapping("{id}")
    public String eliminarCurso(@PathVariable int id) {return cursoService.deleteCurso(id);}

}
