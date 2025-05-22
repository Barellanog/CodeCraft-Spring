package com.codecraft.CodeCraftStudios.controller;

import com.codecraft.CodeCraftStudios.model.Instructor;
import com.codecraft.CodeCraftStudios.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/instructores")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @GetMapping
    public ResponseEntity<List<Instructor>> listarInstructores() {
        List<Instructor> instructores = instructorService.getInstructores();
        if (instructores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(instructores);
    }

    @PostMapping
    public ResponseEntity<Instructor> agregarInstructor(@RequestBody Instructor instructor) {
        Instructor nuevo = instructorService.saveInstructor(instructor);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @GetMapping("{id}")
    public ResponseEntity<Instructor> buscarInstructor(@PathVariable int id) {
        try {
            Instructor inst = instructorService.getInstructorId(id);
            return ResponseEntity.ok(inst);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Instructor> actualizarInstructor(@PathVariable int id, @RequestBody Instructor instructor) {
        try {
            Instructor existente = instructorService.getInstructorId(id);
            existente.setNombre(instructor.getNombre());
            existente.setCorreo(instructor.getCorreo());
            existente.setTelefono(instructor.getTelefono());
            existente.setDireccion(instructor.getDireccion());
            existente.setCurso(instructor.getCurso());

            instructorService.saveInstructor(existente);
            return ResponseEntity.ok(existente);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarInstructor(@PathVariable int id) {
        try {
            instructorService.deleteInstructor(id);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}