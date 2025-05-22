package com.codecraft.CodeCraftStudios.repository;

import com.codecraft.CodeCraftStudios.model.Instructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InstructorRepository {

    private List<Instructor> listaInstructores = new ArrayList<>();

    public List<Instructor> obtenerInstructores() {
        return listaInstructores;
    }

    public Instructor buscarPorId(int id) {
        for (Instructor instructor : listaInstructores) {
            if (instructor.getId() == id) {
                return instructor;
            }
        }
        return null;
    }

    public Instructor guardar(Instructor instructor) {
        listaInstructores.add(instructor);
        return instructor;
    }

    public Instructor actualizar(Instructor instructor) {
        int id = instructor.getId();
        for (int i = 0; i < listaInstructores.size(); i++) {
            if (listaInstructores.get(i).getId() == id) {
                Instructor actualizado = new Instructor();
                actualizado.setId(id);
                actualizado.setNombre(instructor.getNombre());
                actualizado.setCorreo(instructor.getCorreo());
                actualizado.setTelefono(instructor.getTelefono());
                actualizado.setDireccion(instructor.getDireccion());
                actualizado.setCurso(instructor.getCurso());
                listaInstructores.set(i, actualizado);
                return actualizado;
            }
        }
        return null;
    }

    public void eliminar(int id) {
        Instructor instructor = buscarPorId(id);
        if (instructor != null) {
            listaInstructores.remove(instructor);
        }
    }
}