package com.codecraft.CodeCraftStudios.service;

import com.codecraft.CodeCraftStudios.model.Estudiante;
import com.codecraft.CodeCraftStudios.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<Estudiante> getEstudiantes() {
        return estudianteRepository.obtenerEstudiantes();
    }

    public Estudiante saveEstudiante(Estudiante estudiante) {
        return estudianteRepository.guardar(estudiante);
    }

    public Estudiante getEstudianteId(int id) {
        return estudianteRepository.buscarPorId(id);
    }

    public Estudiante updateEstudiante(Estudiante estudiante) {
        return estudianteRepository.actualizar(estudiante);
    }

    public String deleteEstudiante(int id) {
        estudianteRepository.eliminar(id);
        return "Estudiante eliminado";
    }
}