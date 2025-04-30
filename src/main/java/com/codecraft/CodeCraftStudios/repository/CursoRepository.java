package com.codecraft.CodeCraftStudios.repository;

import com.codecraft.CodeCraftStudios.model.Curso;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CursoRepository {

    private List<Curso> listaCursos = new ArrayList<>();

    public List<Curso> obtenerCursos() {
        return listaCursos;
    }

    public Curso buscarPorId(int id) {
        for (Curso curso : listaCursos) {
            if (curso.getId() == id) {
                return curso;
            }
        }
        return null;
    }

    public Curso guardar(Curso cur) {
        listaCursos.add(cur);
        return cur;
    }

    public Curso actualizar(Curso cur) {
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaCursos.size(); i++) {
            if (listaCursos.get(i).getId() == cur.getId()) {
                id = cur.getId();
                idPosicion = i;
            }
        }
        Curso curso1 = new Curso();
        curso1.setId(id);
        curso1.setName(cur.getName());
        curso1.setDescription(cur.getDescription());
        curso1.setFecha(cur.getFecha());
        curso1.setHoraCurso(cur.getHoraCurso());

        listaCursos.set(idPosicion, curso1);
        return curso1;

    }

    public void eliminar(int id) {
        Curso curso = buscarPorId(id);
        if (curso != null) {
            listaCursos.remove(curso);
        }
    }

}

