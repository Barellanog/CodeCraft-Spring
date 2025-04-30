package com.codecraft.CodeCraftStudios.service;

import com.codecraft.CodeCraftStudios.model.Curso;
import com.codecraft.CodeCraftStudios.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> getCursos() {return cursoRepository.obtenerCursos();}

    public Curso saveCurso(Curso curso) {return cursoRepository.guardar(curso);}

    public Curso getCursoId(int id) {return cursoRepository.buscarPorId(id);}

    public Curso updateCurso(Curso curso) {return cursoRepository.actualizar(curso);}

    public String deleteCurso(int id) {
        cursoRepository.eliminar(id);
        return "Curso eliminado";
    }

}
