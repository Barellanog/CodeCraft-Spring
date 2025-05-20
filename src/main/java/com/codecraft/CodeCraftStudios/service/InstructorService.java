package com.codecraft.CodeCraftStudios.service;

import com.codecraft.CodeCraftStudios.model.Instructor;
import com.codecraft.CodeCraftStudios.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public List<Instructor> getInstructores() {
        return instructorRepository.obtenerInstructores();
    }

    public Instructor saveInstructor(Instructor instructor) {
        return instructorRepository.guardar(instructor);
    }

    public Instructor getInstructorId(int id) {
        return instructorRepository.buscarPorId(id);
    }

    public Instructor updateInstructor(Instructor instructor) {
        return instructorRepository.actualizar(instructor);
    }

    public String deleteInstructor(int id) {
        instructorRepository.eliminar(id);
        return "Instructor eliminado";
    }
}