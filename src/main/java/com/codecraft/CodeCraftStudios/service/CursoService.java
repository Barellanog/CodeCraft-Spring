package com.codecraft.CodeCraftStudios.service;

import com.codecraft.CodeCraftStudios.model.Curso;
import com.codecraft.CodeCraftStudios.model.Instructor;
import com.codecraft.CodeCraftStudios.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<Curso> getCursos() {return cursoRepository.obtenerCursos();}

    public Curso saveCurso(Curso curso) {return cursoRepository.guardar(curso);}

    public Curso getCursoId(int id) {return cursoRepository.buscarPorId(id);}

    public Curso updateCurso(Curso curso) {return cursoRepository.actualizar(curso);}

    public String deleteCurso(int id) {
        cursoRepository.eliminar(id);
        return "Curso eliminado";
    }

    public Instructor getInstructorById(int idInstructor) {
        String url = "http://localhost:8081/api/v1/instructores/" + idInstructor;
        return restTemplate.getForObject(url, Instructor.class);
    }
}
