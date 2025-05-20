package com.codecraft.CodeCraftStudios.repository;

import com.codecraft.CodeCraftStudios.model.Estudiante;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EstudianteRepository {

    private List<Estudiante> listaEstudiantes = new ArrayList<>();

    public List<Estudiante> obtenerEstudiantes() {
        return listaEstudiantes;
    }

    public Estudiante buscarPorId(int id) {
        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.getId() == id) {
                return estudiante;
            }
        }
        return null;
    }

    public Estudiante guardar(Estudiante estudiante) {
        listaEstudiantes.add(estudiante);
        return estudiante;
    }

    public Estudiante actualizar(Estudiante estudiante) {
        int id = estudiante.getId();
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            if (listaEstudiantes.get(i).getId() == id) {
                Estudiante actualizado = new Estudiante();
                actualizado.setId(id);
                actualizado.setNombre(estudiante.getNombre());
                actualizado.setEdad(estudiante.getEdad());
                actualizado.setGenero(estudiante.getGenero());
                actualizado.setCorreo(estudiante.getCorreo());
                actualizado.setTelefono(estudiante.getTelefono());
                listaEstudiantes.set(i, actualizado);
                return actualizado;
            }
        }
        return null;
    }

    public void eliminar(int id) {
        Estudiante estudiante = buscarPorId(id);
        if (estudiante != null) {
            listaEstudiantes.remove(estudiante);
        }
    }
}